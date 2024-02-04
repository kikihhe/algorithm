package com.xiaohe.动态规划.不相交的线;

/**
 * 跟最长公共子序列一样
 */
class Solution {
    public int maxUncrossedLines(int[] arr1, int[] arr2) {
        // dp[i][j] : 直到arr1的i位置与arr2的j位置，有几条不相交的线
        int[][] dp = new int[arr1.length + 1][arr2.length + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (arr1[i-1] == arr2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {1,3,7,1,7,5};
        int[] arr2 = new int[] {1,9,2,5,1};
        System.out.println(new Solution().maxUncrossedLines(arr1, arr2));

    }
}