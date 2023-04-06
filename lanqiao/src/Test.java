import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-04-06 20:00
 */
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long time = scanner.nextLong();

        LocalDateTime ceshi = LocalDateTime.ofEpochSecond(time / 1000, 0, ZoneOffset.ofHours(8));

        LocalDateTime localDateTime = Instant.ofEpochMilli(time).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
//        System.out.println(localDateTime.withHour());
    }
}
