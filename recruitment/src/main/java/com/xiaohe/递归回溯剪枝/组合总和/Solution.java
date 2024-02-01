package com.xiaohe.递归回溯剪枝.组合总和;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<Integer>> ret;
    private List<Integer> list;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ret = new ArrayList<>();
        list = new ArrayList<>();
        process(candidates, 0, 0, target);
        return ret;
    }

    /**
     * @param arr
     * @param index  现在遍历到哪个位置了
     * @param sum    遍历过的所有数的总和
     * @param target 需要得到的总和
     */
    private void process(int[] arr, int index, int sum, int target) {
        if (sum == target) {
            ret.add(new ArrayList<>(list));
            return;
        }
        if (sum > target || index == arr.length) {
            return;
        }
        for (int i = index; i < arr.length; i++) {
            list.add(arr[i]);
            process(arr, i, sum + arr[i], target);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> lists = new Solution().combinationSum(arr, target);
        lists.forEach(System.out::println);
    }
}