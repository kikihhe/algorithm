package com.xiaohe.动态规划.最小花费爬楼梯;

/**
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 *
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 *
 * 请你计算并返回达到楼梯顶部的最低花费。
 */
class Solution {
    /**
     * 状态显示: dp[i] : 爬到i位置最小的花费
     * 状态转移:
     *      - 如果是爬一层到此位置，dp[i] = dp[i-1] + cost[i-1]
     *      - 如果是爬两层到此位置，dp[i] = dp[i-2] + cost[i-2]
     *      计算这种情况的最小值
     */
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length <= 1) return 0;
        int[] dp = new int[cost.length + 1];
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }
}