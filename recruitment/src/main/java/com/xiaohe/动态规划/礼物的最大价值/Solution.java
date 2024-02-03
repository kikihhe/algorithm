package com.xiaohe.动态规划.礼物的最大价值;

class Solution {
    public int jewelleryValue(int[][] arr) {
        int[][] dp = new int[arr.length + 1][arr[0].length + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + arr[i - 1][j - 1];
            }
        }
        return dp[arr.length][arr[0].length];
    }

    public static void main(String[] args) {
//        [1,3,1],[1,5,1],[4,2,1]
        int[][] arr = new int[][] {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(new Solution().jewelleryValue(arr));
    }
}