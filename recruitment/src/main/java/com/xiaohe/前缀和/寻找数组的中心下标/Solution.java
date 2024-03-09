package com.xiaohe.前缀和.寻找数组的中心下标;

/**
 * 给你一个整数数组 nums ，请计算数组的 中心下标 。
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。

 * 输入：nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 中心下标是 3 。
 * 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
 * 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
 */
class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        System.out.println(new Solution().pivotIndex(arr));
    }

    /**
     * 解题思路:
     * 1. 计算从左到右的前缀和
     * 2. 计算从右到左的前缀和
     * 从左到右遍历，相等就停止，没有就返回 -1
     * @param arr
     * @return
     */
    public int pivotIndex(int[] arr) {
        int[] left = new int[arr.length + 2];
        int[] right = new int[arr.length + 2];
        // 计算从左到右的和、从右到左的和
        for (int i = 0; i < arr.length; i++) {
            left[i + 1] = left[i] + arr[i];
            right[arr.length - i] = right[arr.length - i + 1] + arr[arr.length - i - 1];
        }
        for (int i = 1; i <= arr.length; i++) {
            if (left[i] == right[i]) {
                return i - 1;
            }
        }
        return -1;
    }
}