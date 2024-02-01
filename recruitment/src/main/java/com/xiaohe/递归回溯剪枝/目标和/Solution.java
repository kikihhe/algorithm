package com.xiaohe.递归回溯剪枝.目标和;

/**
 * 暴力枚举，也可以用动态规划做
 */
class Solution {
    private int count;

    public int findTargetSumWays(int[] nums, int target) {
        process(nums, 0, target, 0);
        return count;
    }

    private void process(int[] arr, int sum, int target, int index) {
        // 遍历到结尾时，如果此时的和为 target 就 count++
        if (index == arr.length) {
            if (sum == target) {
                count++;
            }
            return;
        }

        // 没有遍历到结尾，这个数有两种情况:
        // +
        // -
        process(arr, sum - arr[index], target, index + 1);
        process(arr, sum + arr[index], target, index + 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 1};
        int count = new Solution().findTargetSumWays(arr, 2);
        System.out.println(count);
    }
}