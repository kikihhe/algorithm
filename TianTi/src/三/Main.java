package 三;

import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-04-16 14:28
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();


        if (a > 0 && b > 0 || a + b > 0) {
            System.out.println(Math.max(a, b) + " " + (a+b));
            System.out.println("^_^");
        } else if(a < 0 && b < 0) {
            System.out.println("-_-");
        } else if(a + b < 0 || a + b == 0) {
            System.out.println(Math.max(a,b) + " " + 0);
            System.out.println("T_T");
        }

    }
}
