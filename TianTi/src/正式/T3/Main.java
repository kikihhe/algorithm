package 正式.T3;

import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-04-22 13:35
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String X = scanner.next();
        int M = scanner.nextInt();
        int K = scanner.nextInt();

        if (K == N) {
            System.out.println("mei you mai " + X + " de");
        } else if (K == M) {
            System.out.println("kan dao le mai " + X + " de");
        } else {
            System.out.println("wang le zhao mai " + X + " de");
        }
    }
}
