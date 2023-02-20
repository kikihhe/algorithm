package 尼克的任务;

import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-10-22 14:08
 */
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // n代表多长时间的工作时长
        int n = s.nextInt();
        // m代表多少任务
        int m = s.nextInt();
        // 任务开始时间
        int[] start = new int[m+1];
        // 任务花费时间
        int[] cost = new int[m+1];
        for (int i = 1; i <= m; i++) {
            start[i] = s.nextInt();
            cost[i] = s.nextInt();
        }

        int[] dp = new int[n+2];
        for (int i = n; i >= 0; i--) {
            if (isValid(start,i)) {
                // 有新任务,有几个不同的新任务开启?取其中的最大值
                dp[i] = jisuan(dp, start, cost,i);
            } else {
                // 无新任务
                dp[i] = dp[i+1] + 1;
            }

        }
        System.out.println(dp[1]);
    }

    private static int jisuan(int[] dp, int[] start, int[] cost, int i) {
        // 记录花销时间
        int a = 0;
        int max = 0;
        // 遍历
        for (int k = 1; k < start.length; k++) {
            if (start[k] == i) {
                a = dp[ i + cost[k]];
                max = Math.max(max, a);
            }
        }
        return max;
    }

    // 检查有没有任务新开始, true为有新任务开启,false为无任务新开启
    private static boolean isValid(int[] start, int i) {
        for (int k = 1; k < start.length; k++) {
            if (start[k] == i) {
                return true;
            }
        }

        return false;

    }
}
