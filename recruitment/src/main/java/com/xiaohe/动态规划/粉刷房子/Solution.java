package com.xiaohe.动态规划.粉刷房子;

/**
 * 这个题和 买卖股票的最佳时机含冷冻期 很像
 */
class Solution {
    public int minCost(int[][] costs) {
        // dp[i][0] : 将 i 位置的房子粉刷成红色需要的最小花费(加上前面涂房子的花费)
        // dp[i][1] : 将 i 位置的房子粉刷成蓝色需要的最小花费(加上前面涂房子的花费)
        // dp[i][2] : 将 i 位置的房子粉刷成绿色需要的最小花费(加上前面涂房子的花费)

        // 要想计算 dp[i][j] 的最小花费，假如 dp[i][1]，就必须知道 dp[i-1] 的最少花费，由于相邻房子颜色不能相同，所以
        // dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1]
        int[][] dp = new int[costs.length + 1][3];
        // 对于每一层，也就是每一个房子，计算这个房子涂成三种不同颜色的最小花费
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < 3; j++) {
                // 假如此时计算的是蓝色房子，j = 1, 那么a=2,b=0
                int a = (j + 1) % 3;
                int b = (j + 2) % 3;
                dp[i][j] = Math.min(dp[i-1][a], dp[i-1][b]) + costs[i - 1][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, dp[dp.length - 1][i]);
        }
        return min;
    }

    public static void main(String[] args) {
//                [17,2,17],[16,16,5],[14,3,19]
        int[][] arr = new int[][] {
                {17, 2, 17},
                {16, 16, 5},
                {14, 3, 19}
        };
        System.out.println(new Solution().minCost(arr));

    }
}