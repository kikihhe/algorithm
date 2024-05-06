package com.xiaohe.动态规划.股票问题.买卖股票的最佳时机Ⅰ;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0
 *
 * 注意 : 只能购买一次
 */
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