package 全排列Ⅱ;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<Integer>> list = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    /**
     * 数组中某一个位置是否使用过
     */
    private boolean[] check = null;


    public List<List<Integer>> permuteUnique(int[] arr) {

        check = new boolean[arr.length];
        dfs(arr);
        return list;
    }
    private void dfs(int[] arr) {
        // 结束条件
        if (path.size() == arr.length) {
            list.add(new ArrayList<>(path));
            return;
        }

        boolean[] used = new boolean[300];
        // 循环
        for (int i = 0; i < arr.length; i++) {
            if (check[i]) {
                continue;
            }
            // 如果没有用过
            // 为什么+10 ？ 因为arr[i]可能有负数，又因为arr[i]的范围为 [-10. 10]，
            // 所以加10就可以避免负数越界
            if (!used[arr[i] + 10]) {
                // 添加到数组中
                path.add(arr[i]);
                // 标记为用过
                used[arr[i] + 10] = true;
                check[i] = true;
                // 使用
                dfs(arr);
                path.remove(path.size() - 1);
                check[i] = false;

            }

        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1,1,2};
        List<List<Integer>> lists = solution.permuteUnique(arr);
        System.out.println(lists);
    }
}