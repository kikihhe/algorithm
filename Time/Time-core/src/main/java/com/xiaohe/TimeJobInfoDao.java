package com.xiaohe;

import java.util.List;

/**
 * @ClassName TimeJobInfoDao
 * @Description
 * @Author 何
 * @Date 2023-08-11 14:27
 * @Version 1.0
 */
@Mapper
public interface TimeJobInfoDao {
    /**
     * 根据定时任务的额名称获取任务的信息
     * @param name 名称
     * @return 定时任务信息
     */
    TimeJobInfo loadByName(String name);

    /**
     * 更新定时任务中的信息，按照id
     * @param info
     * @return
     */
    int save(TimeJobInfo info);

    /**
     * 查询数据库中所有定时任务
     * @return
     */
    List<TimeJobInfo> findAll();

    /**
     * 查询指定时间后10s内执行的定时任务
     * @param maxNextTime
     * @return
     */
    List<TimeJobInfo> scheduledJobQuery(long maxNextTime);

}
