package 蓝桥杯第二次模拟赛;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-11-25 11:20
 */
public class Main2 {
    public static void main(String[] args) throws ParseException {
        String str1 = "1949-10-01";
        String str2 = "2022-01-01";
        int i = daysBetween(str1, str2);
        System.out.println(i);

    }
    /**
     * JAVA计算两个日期相差多少天(by date)
     * @author zhengkai.blog.csdn.net
     */
    public static int daysBetween(Date date1, Date date2){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        long time1 = cal.getTimeInMillis();
        cal.setTime(date2);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);
        return Integer.parseInt(String.valueOf(between_days));
    }
    /**
     * JAVA计算两个日期相差多少天(by Date String with format "yyyy-MM-dd")
     * @author zhengkai.blog.csdn.net
     */
    public static int daysBetween(String date1str,String date2str) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = format.parse(date1str);
        Date date2 = format.parse(date2str);
        int a = (int) ((date1.getTime() - date2.getTime()) / (1000*3600*24));
        return a;
    }

}
