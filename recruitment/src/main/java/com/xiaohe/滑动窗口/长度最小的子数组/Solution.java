package com.xiaohe.滑动窗口.长度最小的子数组;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * 解题步骤 : 定义两个指针: left、right，用这两个指针形成的窗口与 target 做对比，
 *          1. 当窗口和 < target 时，让 arr[right + 1] 进窗口。
 *          2. 当窗口和 > target 时，让 arr[left] 出窗口
 *          由于找的是窗口的最小值，所以，在每一次出窗口时判断此时窗口大小是否为最小值。
 * @author : 小何
 * @Description :
 * @date : 2024-02-01 22:12
 */
public class Solution {
    public int minSubArrayLen(int target, int[] arr) {
        int sum = 0;
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        while (right < arr.length) {
            // 进窗口
            sum = sum + arr[right];
            // 判断，如果 arr[left] + ... + arr[right] >= target，让左窗口移动
            while (sum >= target) {
                min = Math.min(min, right - left + 1);
                // 出窗口
                sum = sum - arr[left];
                left++;
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 2, 4, 3};
        int target = 7;

        int[] arr1 = new int[]{1, 4, 4};
        int target1 = 4;

        int count = new Solution().minSubArrayLen(target1, arr1);
        System.out.println(count);
    }
}
