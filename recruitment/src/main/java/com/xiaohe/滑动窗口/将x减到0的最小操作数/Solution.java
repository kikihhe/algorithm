package com.xiaohe.滑动窗口.将x减到0的最小操作数;

/**
 * 给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。
 * 请注意，需要 修改 数组以供接下来的操作使用。
 * 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。
 *
 * 输入：nums = [1,1,4,2,3], x = 5
 * 输出：2
 * 解释：最佳解决方案是移除后两个元素，将 x 减到 0 。
 *
 * 解题关键 ：计算整个数组的和 sum，找到数组中最长的子数组，使其之和 = sum - x
 */
class Solution {
    public int minOperations(int[] arr, int x) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum < x) return -1;
        if (sum == x) return arr.length;
        int left = 0;
        int right = 0;
        int a = 0;
        int max = 0;
        while (right < arr.length) {
            a += arr[right];
            while (a > sum - x) {
                if (a == sum - x) {
                    max = Math.max(max, right - left + 1);
                }
                a -= arr[left++];
            }
            right++;
        }
        return max == 0 ? -1 : arr.length - max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,4,2,3};
        int x = 11;
        System.out.println(new Solution().minOperations(arr, x));
    }
}