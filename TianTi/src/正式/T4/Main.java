package 正式.T4;

import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-04-22 13:41
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            if (i != 0) {
                System.out.println();
            }
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int C = scanner.nextInt();
            if(C == A * B) {
                System.out.print("Lv Yan");
            } else if (C == A + B) {
                System.out.print("Tu Dou");
            } else {
                System.out.print("zhe du shi sha ya!");
            }
        }
    }
}
