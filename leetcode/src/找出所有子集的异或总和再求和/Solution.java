package 找出所有子集的异或总和再求和;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<Integer>> list = new ArrayList<>();
    private List<Integer> path = new ArrayList<>(); 

    public int subsetXORSum(int[] nums) {
        dfs(nums, 0);

        System.out.println(list);
        int sum = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).size() == 0) continue;
            int e = list.get(i).get(0);
            for (int i1 = 1; i1 < list.get(i).size(); i1++) {
                e ^= list.get(i).get(i1);
            }
            sum += e;
        }
        return sum;

    }
    private void dfs(int[] arr, int index) {
        if (index == arr.length) {
            list.add(new ArrayList<>(path));
            return;
        }
        // 不选
        dfs(arr, index + 1);

        // 选
        path.add(arr[index]);
        dfs(arr, index + 1);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{3,4,5,6,7,8};
        int i = solution.subsetXORSum(arr);
        System.out.println(i);
    }
}