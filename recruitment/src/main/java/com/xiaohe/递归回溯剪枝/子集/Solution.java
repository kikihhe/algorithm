package com.xiaohe.递归回溯剪枝.子集;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集 和 全排列 要一起做，体会差距
 */
public class Solution {
    private List<List<Integer>> ret = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        process(nums, 0);
        return ret;
    }
    private void process(int[] arr, int index) {
        // 如果此时递归到数组结尾，直接将当前list加入结果集合中
        if (index >= arr.length) {
            ret.add(new ArrayList<>(list));
            return;
        }
        // 如果还没有遍历到，此 index 的数据有两种情况:
        // 1. 要
        list.add(arr[index]);
        process(arr, index + 1);
        list.remove(list.size() - 1);
        // 2. 不要
        process(arr, index + 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3};
        List<List<Integer>> subsets = new Solution().subsets(arr);
        subsets.forEach(System.out::println);
    }
}