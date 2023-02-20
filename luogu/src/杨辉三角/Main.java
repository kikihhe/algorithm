package 杨辉三角;

import java.util.Arrays;
import java.util.Scanner;

/**
 输入数据首先包含一个正整数T ( T < 10 )，表示有 T 组测试数据,
 每组测试数据只包含一个正整数n（1 <= n <= 20），表示将要输出的杨辉三角的层数。
 1 0 0 0 0
 1 1 0 0 0
 1 2 1 0 0
 1 3 3 1 0
 1 4 6 4 1

 */
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        // n行数据
        int n = 0;
        int[][] dp = null;
        for(int k = 0; k < T; k++) {
            n = s.nextInt();
            dp = new int[n][n];
            dp[0][0] = 1;
            for (int i = 0; i < n; i++) {
                dp[i][0] = 1;
            }
            for (int i = 1; i < n; i++) {
                for (int j = 1; j <= i; j++) {
                    dp[i][j] = dp[i-1][j]+dp[i-1][j-1];
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    System.out.print(dp[i][j] + " ");
                }
                System.out.println();
            }



        }
    }
}
