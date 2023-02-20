package 最长回文子串;

import java.util.Scanner;

class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = true;
            }
        }
        char[] arr = s.toCharArray();
        for (int i = length - 2; i >= 0; i--) {
            for (int j = length - 1; j > i; j--) {
                dp[i][j] = (arr[i] == arr[j]) && dp[i+1][j-1];
            }
        }
        int max = 0;
        int start = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (dp[i][j] && (j - i + 1) > max) {
                    max = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + max);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String result = s.longestPalindrome("abcd");

        System.out.println(result);

    }
}