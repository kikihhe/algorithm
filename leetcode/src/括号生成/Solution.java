package 括号生成;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<String> list = new ArrayList<>();


    public List<String> generateParenthesis(int n) {
        dfs("", 0, 0, n);
        return list;

    }

    private void dfs(String path, int left, int right, int n) {
        // 终止条件
        if (left + right == 2 * n) {
            list.add(path);
            return;
        }
        // 选择
        // 如果left <= n, 可以选择左括号
        if (left < n) {
            dfs(path + "(", left + 1, right, n);
        }
        // 如果right < left, 可以选择右括号
        if (right < left && right < n) {
            dfs(path + ")", left, right + 1, n);
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> strings = solution.generateParenthesis(3);
        System.out.println(strings);
    }
}