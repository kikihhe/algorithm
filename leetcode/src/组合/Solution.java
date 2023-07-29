package 组合;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<Integer>> list = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        // 从 1 到 N 中挑取k个数组成随意数组
        dfs(n, 1, k, 0);
        return list;
        
    }
    // index : 挑选到第几个了
    // count : 已经挑选几个了
    private void dfs(int n, int index, int k, int count) {
        if (count == k) {
            list.add(new ArrayList<>(path));
            return;
        }
        if (index > n) {
            return;
        }

        // 不挑这个数
        dfs(n, index + 1, k, count);
        // 挑这个数
        path.add(index);
        dfs(n, index + 1, k, count + 1);
        path.remove(path.size() - 1);

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> combine = solution.combine(1, 1);
        System.out.println(combine);
    }
}