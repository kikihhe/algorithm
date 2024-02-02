package com.xiaohe.动态规划.三步问题;

/**
 * 有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。
 * 结果可能很大，你需要对结果模1000000007。
 */
class Solution {
    private int mod = 1000000007;
    public int waysToStep(int n) {
        if (n < 3) return n;
        if (n == 3) return 4;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        // dp[4] = 7
        for (int i = 4; i <= n; i++) {
            dp[i] = ((dp[i - 1] + dp[i - 2]) % mod + dp[i - 3]) % mod;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().waysToStep(1000000));
    }
}