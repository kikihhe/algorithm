package 前缀和.模拟二;

import java.util.Scanner;

/**
 * @ClassName Main
 * @Description 二维前缀和
 * @Author 何
 * @Date 2023-08-13 19:07
 * @Version 1.0
 * 给定一个二维数组，n行 m列，再给定 (x1,y1)、(x2,y2) 两个坐标，求这两个坐标中的所有数字之和
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =scanner.nextInt();
        int m =scanner.nextInt();
        int[][] arr = new int[n + 1][m + 1];
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                arr[i][j] = scanner.nextInt();
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + arr[i][j];
            }
        }
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();


        System.out.println(dp[x2][y2] - dp[x2][y1] - dp[x1][y2] + dp[x1][y1]);

    }
}
