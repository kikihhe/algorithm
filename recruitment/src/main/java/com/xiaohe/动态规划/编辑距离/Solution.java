package com.xiaohe.动态规划.编辑距离;

/**
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 */
public class Solution {
    /**
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();

        int[][] dp = new int[arr1.length + 1][arr2.length + 1];
        for (int i = 0; i <= arr1.length; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= arr2.length; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < arr1.length + 1; i++) {
            for (int j = 1; j < arr2.length + 1; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = min(dp[i - 1][j - 1], dp[i-1][j], dp[i][j-1]) + 1;
                }
            }
        }

        return dp[arr1.length][arr2.length];
    }
    private int min(int a, int b, int c) {
        int temp = Math.min(a, b);
        temp = Math.min(temp, c);
        return temp;
    }

    public static void main(String[] args) {
        String str1 = "intention";
        String str2 = "execution";
        System.out.println(new Solution().minDistance(str1, str2));
    }
}