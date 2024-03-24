package com.xiaohe.动态规划.让字符串成为回文串的最少插入次数;

/**
 * 这道题和 最长公共子序列 一起写
 *
 * 给你一个字符串 s ，每一次操作你都可以在字符串的任意位置插入任意字符。
 *
 * 请你返回让 s 成为回文串的 最少操作次数 。
 *
 * 输入：s = "leetcode"
 * 输出：5
 * 解释：插入 5 个字符后字符串变为 "leetcodocteel" 。
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().minInsertions("leetcode"));
        System.out.println(new Solution().minInsertions("mbadm"));
        System.out.println(new Solution().minInsertions("zzazz"));
    }
    /**
     * 解题思路 : 将 str1 颠倒过来形成新字符串 str2, str1 和 str2 的长度为length
     * 求 str1 和 str2 的最长公共子序列，使用 length - 最长公共子序列 即可得到最少操作次数
     */
    public int minInsertions(String str1) {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = new char[arr1.length];
        // 反转字符串
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] = arr1[arr1.length - 1 - i];
        }

        int[][] dp = new int[arr1.length + 1][arr2.length + 1];
        for (int i = 1; i <= arr1.length; i++) {
            for (int j = 1; j <= arr2.length; j++) {
                if (arr1[i-1] == arr2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return str1.length() - dp[arr1.length][arr1.length];
    }
}