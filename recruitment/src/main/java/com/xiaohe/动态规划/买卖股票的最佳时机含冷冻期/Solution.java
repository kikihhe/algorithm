package com.xiaohe.动态规划.买卖股票的最佳时机含冷冻期;

/**
 * 这道题跟粉刷房子有点像
 */
public class Solution {
    public int maxProfit(int[] prices) {
        // dp[i][0] : 第i天的最大利润，今天的股票处于买入状态
        // dp[i][1] : 第i天的最大利润，今天的股票处于可买入状态
        // dp[i][2] : 第i天的最大利润，今天的股票处于冷冻状态

        // 状态转移: 如果今天是 x 状态，那么昨天有可能为 y 状态:
        // 买入状态 <- 买入状态、可买入状态
        // 可买入状态 <- 可买入状态、冷冻状态
        // 冷冻状态 <- 买入状态
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0];

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2]);
            dp[i][2] = dp[i][0] + prices[i];
        }
        return Math.max(dp[dp.length - 1][1], dp[dp.length - 1][2]);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 0, 2};
        System.out.println(new Solution().maxProfit(arr));
    }
}