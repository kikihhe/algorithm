package com.xiaohe.动态规划.删除并获得点数;

/**
 * 特别有意思的一道题
 *
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 *
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 *
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 *
 *
 */
class Solution {
    public int deleteAndEarn(int[] nums) {
        // 统计数组中的最大值，创建辅助数组时使用 这个最大值+1 当长度
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int[] sum = new int[max + 1];
        // 将值为 a 的数据加到 sum[a] 上。
        for (int i = 0; i < nums.length; i++) {
            sum[nums[i]] += nums[i];
        }
        // 问题转换为打家劫舍问题
        // dp[i] 到下标为i位置时的最大价值
        // 不选这个位置，dp[i] = dp[i - 1]
        // 选这个位置, dp[i] = dp[i - 2] + arr[i]
        int[] dp = new int[sum.length + 1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sum[i-1]);
        }
        return dp[sum.length];
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2,2,3,3,3,4};
        System.out.println(new Solution().deleteAndEarn(arr));
    }
}