package 正式.T7;

import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-04-22 14:41
 */
public class Main {
    // 将a的各个位置相加
    public static int process(int a) {
        char[] arr = (a + "").toCharArray();
        int result = 0;
        for (int i = 0 ; i < arr.length; i++) {
            result += arr[i]- '0';
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                System.out.println();
            }
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int sa = process(a);
            int sb = process(b);
            if (a % sb == 0 && b % sa == 0) {
                System.out.print(a > b ? "A" : "B");
            } else if (a % sb == 0) {
                System.out.print("A");
            } else if (b % sa == 0) {
                System.out.print("B");
            } else {
                System.out.print(a > b ? "A" : "B");
            }

        }
    }
}
