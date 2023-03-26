package 组数总和;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        process(candidates, 0, target, new ArrayList<Integer>(), result);

        return result;

    }
    private void process(int[] arr, int index, int target, List<Integer> now, List<List<Integer>> result) {
        // 下标超了直接g
        if (index >= arr.length) return;

        if (0 == target) {
            result.add(new ArrayList<Integer>(now));
            return;
        }
        // 如果当前下标的值不等于目标，有两种解决办法:
        // 1. 不要当前值
        process(arr, index+1, target, now, result);

        // 2. 要当前值
        if (target - arr[index] >= 0) {
            now.add(arr[index]);
            process(arr, index, target-arr[index], now, result);
            now.remove(now.size()-1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> lists = s.combinationSum(arr, target);
        lists.forEach(System.out::println);
    }
}