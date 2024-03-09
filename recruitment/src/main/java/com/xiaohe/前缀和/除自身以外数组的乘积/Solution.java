package com.xiaohe.前缀和.除自身以外数组的乘积;

/**
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */
class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 3, 4};
        System.out.println(new Solution().productExceptSelf(arr));
    }

    /**
     * 解题思路:
     * 1. 从左到右计算乘积, left[i] 从 0 乘到 i 位置的总乘积
     * 2. 从右到左计算乘积 right[i] 从 arr.length 乘到 i 位置的总乘积
     * 计算 result[i] = left[i - 1] * right[i + 1]
     */
    public int[] productExceptSelf(int[] arr) {
        int[] left = new int[arr.length + 2];
        int[] right = new int[arr.length + 2];
        left[0] = 1;
        right[arr.length + 1] = 1;
        for (int i = 0; i < arr.length; i++) {
            left[i + 1] = left[i] * arr[i];
            right[arr.length - i] = right[arr.length - i + 1] * arr[arr.length - i - 1];
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = left[i] * right[i + 2];
        }
        return result;
    }
}