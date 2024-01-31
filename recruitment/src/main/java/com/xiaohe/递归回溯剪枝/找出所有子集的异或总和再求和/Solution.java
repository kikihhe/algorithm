package com.xiaohe.递归回溯剪枝.找出所有子集的异或总和再求和;

/**
 * 这个跟 子集 很像，这两个题是两种不同的解法，可以相互转换
 */
public class Solution {
    private int sum;
    private int path;
    public int subsetXORSum(int[] nums) {
        process(nums, 0);
        return sum;
    }
    private void process(int[] arr, int index) {
        sum += path;
        for (int i = index; i < arr.length; i++) {
            path = path ^ arr[i];
            process(arr, i + 1);
            path = path ^ arr[i];
        }
    }
}