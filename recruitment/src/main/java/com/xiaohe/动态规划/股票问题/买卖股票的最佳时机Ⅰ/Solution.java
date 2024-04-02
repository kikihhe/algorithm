package com.xiaohe.动态规划.股票问题.买卖股票的最佳时机Ⅰ;

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 1) return 0;
        // dp[i][0] 代表彩票的历史最低价格，将价格变为负数，求最大值就是彩票的最小价格
        // dp[i][1] 代表卖出彩票所获得的最大利润，上一天的利润与当前比较(利润计算方法: dp[i][1] = dp[i-1][0] + prices[i])
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
        }
        return dp[prices.length - 1][1];
    }
}