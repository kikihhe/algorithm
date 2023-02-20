package 采药;

import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-10-24 16:12
 */
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt(); // 总时间
        int M = s.nextInt(); // 总药数
        int[] time = new int[M+1];
        int[] value = new int[M+1];
        for (int i = 1; i < M+1; i++) {
            time[i] = s.nextInt();
            value[i] = s.nextInt();
        }

        int[][] dp = new int[M+1][T+1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i-1][j];
                if (time[i] <= j) {
                    dp[i][j] = Math.max(value[i] + dp[i-1][j-time[i]], dp[i-1][j]);
                }
            }
        }
        System.out.println(dp[dp.length-1][dp[0].length-1]);

    }
}
