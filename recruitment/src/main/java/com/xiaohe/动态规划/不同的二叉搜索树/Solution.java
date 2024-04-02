package com.xiaohe.动态规划.不同的二叉搜索树;

class Solution {
    /**
     * 计算 [1, i] 可以组成多少个搜索树时，要计算以 j ∈ [1, i] 中各个元素当头节点时有多少个搜索树之和。
     * j 的左边有 j-1 个节点，j 的右边有 i-j 个节点
     * 所以 dp[i] = dp[i] + dp[j - 1] * dp[i - j]
     */
    public int numTrees(int n) {
        if (n < 3) return n;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 计算 [1, i] 可以组成多少个搜索树时，要计算以 j ∈ [1, i] 中各个元素当头节点时有多少个搜索树之和。
            // j 的左边有 j-1 个节点，j 的右边有 i-j 个节点
            // 所以 dp[i] = dp[i] + dp[j - 1] * dp[i - j]
            for (int j = 1; j <= i; j++) {
                dp[i] = dp[i] + dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}