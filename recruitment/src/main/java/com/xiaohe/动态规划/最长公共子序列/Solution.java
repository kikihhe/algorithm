package com.xiaohe.动态规划.最长公共子序列;

class Solution {
    public int longestCommonSubsequence(String str1, String str2) {
        // dp[i][j] : str1中以i结尾的字符串与str2中以j结尾的字符串，它俩的最长公共子序列有多长
        // str1[i] == str2[j] : dp[i][j] = dp[i-1][j-1] + 1
        // str1[i] != str2[j] : dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonSubsequence("abc", "ac"));
    }
}