package 最长回文子串;

import java.util.Scanner;

class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        char[] arr = s.toCharArray();
        int start = 0;
        int max = 1;
        boolean[][] dp = new boolean[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = true;
            }
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            for (int j = arr.length - 1; j > i; j--) {
                dp[i][j] = (arr[i] == arr[j]) && dp[i+1][j-1];
                if (dp[i][j] && j - i + 1 > max) {
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