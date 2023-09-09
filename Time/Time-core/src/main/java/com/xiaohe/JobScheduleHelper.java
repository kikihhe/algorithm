package com.xiaohe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.CronExpression;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName JobScheduleHelper
 * @Description 调度中心帮助器
 * @Author 何
 * @Date 2023-08-11 14:14
 * @Version 1.0
 */
public class JobScheduleHelper {
    private static Logger logger = LoggerFactory.getLogger(JobScheduleHelper.class);


    private TimeJobInfoDao timeJobInfoDao;
    public String scheduledCron = "0 0 0 * * ?";

    /**
     * 查询当前时间5秒之内执行的任务
     */
    public static final long PRE_READ_MS = 5000;

    /**
     * 时间轮线程
     * 这个时间轮线程是用来向触发器线程池提交触发任务的
     * 它提交的任务从Map获取，而Map中的任务是从上面的调度线程添加的。
     */
    private Thread ringThread;

    /**
     * 调度定时任务的线程，向时间轮中添加任务
     */
    private Thread scheduledThread;
    /**
     * 这个就是时间轮的容器，该容器中的数据是由scheduleThread线程添加的
     * 但是移除是由ringThread线程移除的
     * Map的key为时间轮中任务的执行时间，也就是在时间轮中的刻度，value是需要执行的定时任务的集合，这个集合中的数据就是需要执行的定时任务的id
     * 意思就是在这个时间，有这么多定时任务要被提交给调度线程池
     */
    private volatile static Map<Integer, List<Integer>> ringData = new ConcurrentHashMap<>();

    private static JobScheduleHelper instance = new JobScheduleHelper();


    /**
     * 暴露JobScheduleHelper实例
     *
     * @return JobScheduleHelper
     */
    public static JobScheduleHelper getInstance() {
        return instance;
    }


    /**
     * 启动调度线程工作的方法
     */
    public void start() {
         scheduledThread = new Thread(() -> {
             while (true) {
                 // 本次是否从数据库中读取到了数据
                 boolean preReadSuc = true;
                 long nowTime = System.currentTimeMillis();
                 List<TimeJobInfo> jobInfoList = timeJobInfoDao.scheduledJobQuery(nowTime + PRE_READ_MS);
                 if (Objects.isNull(jobInfoList) && jobInfoList.isEmpty()) {
                     preReadSuc = false;
                 }
                 // 遍历本次查询的所有定时任务
                 for (TimeJobInfo jobInfo : jobInfoList) {
                     if (nowTime > jobInfo.getTriggerNextTime() + PRE_READ_MS) {
                         // 在这里做了一个判断，刚才得到的当前时间，是不是大于任务的下一次执行时间加上5s
                         // 为什么这么做？如果一个任务在 11s 时需要被执行，那么它在6s时需要被预读并放在时间轮中，但是5s时服务器宕机直到20s才恢复
                         // 即: 当前时间是否 > 指定被执行时间+预读时间
                         // 那么这里就可以做一个补救措施
                         JobTriggerPoolHelper.trigger(jobInfo);
                         // 因为定时任务已经严重过期了，所以计算一下次的执行时间就应该以当前时间为标志了
                         refreshNextValidTime(jobInfo, new Date());
                     } else if (nowTime > jobInfo.getTriggerNextTime()) {
                         // 这里得到的就是要执行的任务的下一次执行时间同样也小于了当前时间，但是这里和上面的不同是，没有超过当前时间加5秒的那个时间
                         // 上面加的那个5秒实际上就是调度周期，每一次处理的任务都是当前任务加5秒这个时间段内的
                         // 这一次得到的任务仅仅是小于当前时间，但是并没有加上5秒，说明这个任务虽然过期了但仍然是在当前的调度周期中
                         // 比如说这个任务要在第2秒执行，但是服务器在第1秒宕机了，恢复之后已经是第4秒了，现在任务的执行时间小于了当前时间，但是仍然在5秒的调度器内
                         // 所以调度执行即可
                         JobTriggerPoolHelper.trigger(jobInfo);
                         //刷新该任务下一次的执行时间，也是过期任务，所以也已当前时间为标准来计算下一次执行时间
                         refreshNextValidTime(jobInfo, new Date());
                         //下面这个分之中的任务就是比较正常的，但是又有些特殊的，
                         //判断这个任务的下一次执行时间是否小于这个执行周期，注意，上面的refreshNextValidTime方法已经把该任务的下一次执行时间更新了。
                         //如果更新后的时间仍然小于执行周期，说明这个任务会在执行周期中再执行一次，当然，也可能会执行多次，
                         //这时候，就不让调度线程来处理这个任务了，而是把它提交给时间轮，让时间轮去执行。
                         if (nowTime + PRE_READ_MS > jobInfo.getTriggerNextTime()) {
                             //调度线程是按调度周期来处理任务的，举个例子，调度线程从0秒开始启动，第5秒为一个周期，把这5秒要执行的任务交给时间轮了
                             //就去处理下一个调度周期，千万不要把调度线程处理调度任务时不断增加的调度周期就是增长的时间，调度线程每次扫描数据库不会耗费那么多时间
                             //这个时间是作者自己设定的，并且调度线程也不是真的只按整数5秒去调度任务
                             //实际上，调度线程从0秒开始工作，扫描0-5秒的任务，调度这些任务耗费了1秒，再次循环时，调度线程就会从1秒开始，处理1-6秒的任务
                             //虽说是1-6秒，但是1-5秒的任务都被处理过了，但是请大家想一想，有些任务也仅仅只是被执行了一次，如果有一个任务在0-5秒调度器内被执行了
                             //但是该任务每1秒执行一次，从第1秒开始m，那它是不是会在调度期内执行多次？可是上一次循环它可能最多只被执行了两次，一次在调度线程内，一次在时间轮内
                             //还有几次并未执行呢，所以要交给下一个周期去执行，但是这时候它的下次执行时间还在当前时间的5秒内，如果下个周期直接从6秒开始
                             //这个任务就无法执行了，大家可以仔细想想这个过程
                             //时间轮才是真正按照时间增长的速度去处理定时任务的
                             int ringSecond = (int) ((jobInfo.getTriggerNextTime() / 1000) % 60);
                             //把定时任务的信息，就是它的id放进时间轮
                             pushTimeRing(ringSecond, jobInfo.getId());
                             //刷新定时任务的下一次的执行时间，注意，这里传进去的就不再是当前时间了，而是定时任务现在的下一次执行时间
                             //因为放到时间轮中就意味着它要执行了，所以计算新的执行时间就行了
                             refreshNextValidTime(jobInfo, new Date(jobInfo.getTriggerNextTime()));
                         }
                     } else {
                         //最后，这里得到的就是最正常的任务，也就是执行时间在当前时间之后，但是又小于执行周期的任务
                         //上面的几个判断，都是当前时间大于任务的下次执行时间，实际上都是在过期的任务中做判断
                         //这样的任务就很好处理了，反正都是调度周期，也就是当前时间5秒内要执行的任务，所以直接放到时间轮中就行
                         //计算出定时任务在时间轮中的刻度，其实就是定时任务执行的时间对应的秒数
                         //随着时间流逝，时间轮也是根据当前时间秒数来获取要执行的任务的，所以这样就可以对应上了
                         int ringSecond = (int) ((jobInfo.getTriggerNextTime() / 1000) % 60);
                         //放进时间轮中
                         pushTimeRing(ringSecond, jobInfo.getId());
                         //刷新定时任务下一次的执行时间
                         refreshNextValidTime(jobInfo, new Date(jobInfo.getTriggerNextTime()));

                     }
                 }
                 //最后再更一下所有的任务的数据库信息
                 for (TimeJobInfo jobInfo : jobInfoList) {
                     timeJobInfoDao.save(jobInfo);
                 }
                 // 得到扫描数据库 + 调度执行 + 更新数据库 的耗时
                 long cost = System.currentTimeMillis() - nowTime;
                 if (cost < 1000) {
                     try {
                         //下面有一个三元运算，判断preReadSuc是否为true，如果扫描到数据了，就让该线程小睡一会儿，最多睡1秒
                         //如果根本就没有数据，就说明5秒的调度器内没有任何任务可以执行，那就让线程最多睡5秒，把时间睡过去，过5秒再开始工作
                         TimeUnit.MILLISECONDS.sleep((preReadSuc ? 1000 : PRE_READ_MS) - System.currentTimeMillis() % 1000);
                     } catch (InterruptedException e) {
                         logger.error(e.getMessage(), e);
                     }
                 }
             }
         });
         scheduledThread.start();


    }



    /**
     * 把任务放到时间轮中
     *
     * @param ringSecond 任务所在的刻度，0 - 59
     * @param jobId      任务id
     */
    private void pushTimeRing(int ringSecond, int jobId) {
        List<Integer> ringItemDate = ringData.get(ringSecond);
        if (Objects.isNull(ringItemDate)) {
            ringItemDate = new ArrayList<>();
            ringData.put(ringSecond, ringItemDate);
        }
        ringItemDate.add(jobId);
    }


    /**
     * 计算定时任务下一次执行时间
     * @param jobInfo 定时任务
     * @param fromTime 开始时间
     */
    private void refreshNextValidTime(TimeJobInfo jobInfo, Date fromTime) {
        Date nextValidTime = generateNextValidTime(jobInfo, fromTime);
        if (Objects.isNull(nextValidTime)) {
            jobInfo.setTriggerStatus(0);
            jobInfo.setTriggerLastTime(0);
            jobInfo.setTriggerNextTime(0);
        } else {
            jobInfo.setTriggerLastTime(jobInfo.getTriggerNextTime());
            jobInfo.setTriggerNextTime(nextValidTime.getTime());
        }

    }

    public static Date generateNextValidTime(TimeJobInfo jobInfo, Date fromTime) {
        new CronExpression(jobInfo.getScheduledConf()).getNextValidTime();
    }


}
