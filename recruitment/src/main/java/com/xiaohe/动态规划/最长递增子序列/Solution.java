package com.xiaohe.动态规划.最长递增子序列;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        // dp[i] : 从 0 到 i-1 范围内，最长递增子序列的长度。
        // 由于在选择时，dp[i] 要选择 0 到 i-1 之间的dp[j] 最大值，即 dp[i] = max(dp[i], dp[j] + 1) j∈[0,i-1]
        // 所以时间复杂度为 O(n²)
        // 返回值也是从 dp 数组中寻找最大值
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {0,1,0,3,2,3};
        System.out.println(new Solution().lengthOfLIS(arr));
    }
}