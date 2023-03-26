package 组合总数Ⅱ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] is = new boolean[candidates.length];
        Arrays.sort(candidates);
        process(candidates, 0, target, result, list, is);
        return result;

    }
    private void process(int[] arr, int index, int target, List<List<Integer>> result, List<Integer> list, boolean[] is) {
        if (target == 0) {
            if(!result.contains(list) ) {
                result.add(new ArrayList<>(list));
            }
        }
        if (index >= arr.length) return;
        if (is[index]) return;
        if (target < arr[index]) return;

        // 不选
        process(arr, index + 1, target, result, list, is);
        // 选
        if (!is[index] && target - arr[index] >= 0 ) {
            list.add(arr[index]);
            is[index] = true;
            process(arr, index + 1, target-arr[index], result, list, is);
            list.remove(list.size()-1);
            is[index] = false;
        }
        

    }
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] arr = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int target =  30;
        List<List<Integer>> lists = s.combinationSum2(arr, target);
        lists.forEach(System.out::println);
    }
}


