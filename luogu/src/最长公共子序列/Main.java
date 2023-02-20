package 最长公共子序列;

import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-10-22 13:29
 */
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] s1 = new int[n+1];
        int[] s2 = new int[n+1];
        for (int i = 1; i <= n; i++) s1[i] = s.nextInt();
        for (int i = 1; i <= n; i++) s2[i] = s.nextInt();

        int[][] dp = new int[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1[i] == s2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[n][n]);
    }
}
