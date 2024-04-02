package com.xiaohe.动态规划.零钱兑换;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 */
class Solution {
    /**
     * dp[i] : 对于金额 i, 最少需要 dp[i] 个硬币
     * 由于求的是最小值，初始化时 dp[i] 要设置为 Integer.MAX_VALUE
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 将 [1, length] 的值初始化为最大值，保留 dp[0] = 0
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                // 如果当前金额 i 大于等于硬币面额，可以计算
                // 并且要保证 dp[i - coins[j]] != Integer.MAX_VALUE
                if (i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[dp.length - 1] == Integer.MAX_VALUE ? -1 : dp[dp.length - 1];
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2};
        int amount = 3;
        System.out.println(new Solution().coinChange(arr, amount));
    }
}