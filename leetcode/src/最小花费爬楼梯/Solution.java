package 最小花费爬楼梯;

import java.time.LocalDateTime;
import java.util.Date;

public class Solution {

    public static int minCostClimbingStairs1 (int[] cost) {


        return process(cost, -1);
    }
    // cost花费数组
    // i 当前所处楼梯数
    private static int process(int[] cost, int i) {
        if (i >= cost.length - 2) {
            return 0;
        }
        return Math.min(process(cost, i + 1) + cost[i+1], cost[i+2] + process(cost, i + 2));
    }

    public static void main(String[] args) {
        int[] cost = {2,5,20};


        int result1 = minCostClimbingStairs1(cost);
        int result2 = minCostClimbingStairs2(cost);


        System.out.println(result1);
        System.out.println(result2);

    }

    // dp方法
    public static int minCostClimbingStairs2(int[] cost) {

        // 第一节台阶最小花费是0，如果选择了第一节台阶，就是cost[0]
        int[] dp = new int[cost.length + 1];
        // 从最后一个开始
        dp[cost.length] = cost[cost.length - 1];
        dp[cost.length - 1] = cost[cost.length - 2];
        for (int i = cost.length - 2; i >= 0; i--) {
            dp[i] = Math.min( dp[i + 1], dp[i + 2]) +  i - 1 < 0 ? 0 : cost[i - 1];
        }

        return dp[1];
    }
}