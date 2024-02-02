package com.xiaohe.滑动窗口.最大连续1的个数Ⅲ;

/**
 * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 * 输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：[1,1,1,0,0,1,1,1,1,1,1] 反转下标为5和10的0，与旁边的1组成6个1.
 */
class Solution {
    public int longestOnes(int[] nums, int k) {
        int ret = 0;
        int left = 0;
        int right = 0;
        int zero = 0;
        while (right < nums.length) {
            // 进窗口之后判断该元素是否为0
            if (nums[right] == 0) {
                zero++;
            }
            // 如果窗口中的0个数超过了，将左边界右移，移动之前要判断一下nums[left]是否为0
            while (zero > k) {
                if (nums[left] == 0) {
                    zero--;
                }
                left++;
            }
            // 判断
            ret = Math.max(ret, right - left + 1);
            // 进窗口
            right++;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        int i = new Solution().longestOnes(arr, k);
        System.out.println(i);
    }
}