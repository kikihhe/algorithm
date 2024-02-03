package com.xiaohe.动态规划.最小路径和;

/**
 * 这个题跟礼物的最大价值一起看, dp 数组的初始化情况不同。
 */
class Solution {
    public int minPathSum(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];
        dp[0][0] = arr[0][0];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0] + arr[i][0];
        }
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + arr[0][i];
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + arr[i][j];
            }
        }
        return dp[arr.length - 1][arr[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(new Solution().minPathSum(arr));
    }
}