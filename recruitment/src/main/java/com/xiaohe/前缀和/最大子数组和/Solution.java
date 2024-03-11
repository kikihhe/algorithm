package com.xiaohe.前缀和.最大子数组和;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组是数组中的一个连续部分。
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 */
class Solution {
    public static void main(String[] args) {
        int[] arr1 = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] arr2 = new int[]{1};
        int[] arr3 = new int[]{1, -1};
        int[] arr4 = new int[]{5,4,-1,7,8};
        System.out.println(new Solution().maxSubArray(arr1));
        System.out.println(new Solution().maxSubArray(arr2));
        System.out.println(new Solution().maxSubArray(arr3));
        System.out.println(new Solution().maxSubArray(arr4));
    }

    /**
     * 解题思路:
     * sum[i] : 以 i 为结尾的最大子数组的和。
     * 1. 如果 sum[i - 1] > 0 ，就可以使用，sum[i] = sum[i - 1] + arr[i]
     * 2. 如果 sum[i - 1] <= 0，不使用，sum[i] = arr[i]
     * @param arr
     * @return
     */
    public int maxSubArray(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        int[] sum = new int[arr.length];
        int max = arr[0];
        sum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (sum[i - 1] >= 0) {
                sum[i] = sum[i - 1] + arr[i];
            } else {
                sum[i] = arr[i];
            }
            max = Math.max(max, sum[i]);
        }

        return max;
    }
}