package 作业.作业一;

import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-04-12 22:51
 */
public class Three {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter molecule: ");
        int a = scanner.nextInt();
        System.out.println("Please enter denominator: ");
        int b = scanner.nextInt();
//        Simply multiply an int by 0.0 to convert it to double
        System.out.println("answer: " + (a*1.0 / b * 1.0));
    }
}
