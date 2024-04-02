package com.xiaohe.动态规划.股票问题.买卖股票的最佳时机含手续费;

public class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        // dp[i][0] : 从0到第i天的总利润，第 i 天为闲置状态
        // dp[i][1] : 从0到第i天的总利润，第 i 天为买入状态
        // 状态变化的示意图:
        // 闲置 <- 买入
        // 买入 <- 闲置
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 如果今天是闲置状态，那么昨天可能为 闲置、卖出了
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            // 如果今天是买入状态，那么昨天可能为 买入、闲置状态
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return Math.max(dp[dp.length - 1][0], dp[dp.length - 1][1]);
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,3,7,5,10,3};
        int fee = 3;
        System.out.println(new Solution().maxProfit(arr, fee));
    }
}