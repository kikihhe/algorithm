package 时间显示;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.SimpleFormatter;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-04-07 21:36
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long time = scanner.nextLong();
        Date date = new Date(time);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");


        System.out.println(simpleDateFormat.format(date));

    }
}
