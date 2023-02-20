package bite.bite14;

import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-10-25 19:09
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int year = s.nextInt();
        int month = s.nextInt();
        int day = s.nextInt();
        LocalDateTime of = LocalDateTime.of(year, month, day, 0, 0);

        int dayOfYear = of.getDayOfYear();
        System.out.println(dayOfYear);
    }
}
