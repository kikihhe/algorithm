package com.xiaohe.动态规划.编辑距离;

/**
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 *
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 * eg:
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 */
class Solution {
    /**
     * 示例一
     * word1 : abc
     * word2 : abcd
     * 给word1添加一个字符 与 给word2删除一个字符 其实是等价的, 我们可以给word1添加d，也可以给word2删除d
     *
     * 示例二
     * word1 : abcd
     * word2 : abc
     * 给word2添加一个字符 与 给word1删除一个字符 其实是等价的, 我们可以给word2添加d，也可以给word1删除d
     *
     * 示例三
     * word1 : abc
     * word2 : abd
     * 在这里其实修改word1还是修改word2都一样
     *
     * 定义状态转移方程: dp[i][j] : word1[0 - i] 编辑后等于 word2[0 - j] 需要的最小次数
     * 当 word[i] == word2[j] 时，这个字符显然不需要编辑，那么 dp[i][j] = dp[i-1][j-1]
     * 当不等于时，我们就要尝试 给word1添加、给word2添加、给word1编辑，然后取最小值
     *
     * 初始化:
     * 如果word2为空，那么word1想变成空就需要删除所有元素，dp[i][0] = i
     * 如果word1为空，那么word2想变成空就需要删除所有元素，dp[0][j] = j
     */
    public int minDistance(String word1, String word2) {
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        int[][] dp = new int[arr1.length + 1][arr2.length + 1];
        // 初始化
        for (int i = 0; i < arr1.length; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < arr2.length; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= arr1.length; i++) {
            for (int j = 1; j <= arr2.length; i++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = getMin(
                            dp[i-1][j],
                            dp[i][j-1],
                            dp[i-1][j-1]
                    ) + 1;
                }
            }
        }
        return dp[arr1.length][arr2.length];
    }

    private int getMin(int a, int b, int c) {
        int min = Math.min(a, b);
        min = Math.min(min, c);
        return min;
    }
}