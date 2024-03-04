package com.xiaohe.动态规划.最长回文子串;

class Solution {
    public String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        boolean[][] dp = new boolean[arr.length + 1][arr.length + 1];
        for (int j = 0; j < dp[0].length; j++) {
            for (int i = 0; i <= j; i++) {
                dp[i][j] = true;
            }
        }
        int max = 1;
        int begin = 1;
        int end = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < i; j++) {
                if (arr[i - 1] == arr[j - 1] && dp[i - 1][j + 1]) {
                    dp[i][j] = true;
                    if (max < i - j + 1) {
                        max = i - j + 1;
                        begin = j;
                        end = i;
                    }
                }
            }
        }

        return s.substring(begin - 1, end);
    }

    public static void main(String[] args) {
        String s = new Solution().longestPalindrome("abc");
        System.out.println(s);
    }
}