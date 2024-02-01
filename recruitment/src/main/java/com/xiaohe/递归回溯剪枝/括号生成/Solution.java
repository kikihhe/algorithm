package com.xiaohe.递归回溯剪枝.括号生成;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<String> ret = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        process(0, 0, n, "");
        return ret;
    }

    /**
     *
     * @param left 当前循环左括号的数量
     * @param right 当前循环右括号的数量
     * @param n 需要生成的括号的数量
     * @param str 当前括号序列
     */
    private void process(int left, int right, int n, String str) {
        if (right == n) {
            ret.add(new String(str));
            return;
        }
        // 生成左括号 : 如果左括号的数量 >= n，不能生成左括号
        if (left < n) {
            String a = str + "(";
            process(left + 1, right, n, a);
        }
        // 生成右括号 : 如果右括号的数量 >= 左括号的数量，不能生成右括号
        if (right < left) {
            String a = str + ")";
            process(left, right + 1, n, a);
        }

    }

    public static void main(String[] args) {
        List<String> strings = new Solution().generateParenthesis(3);
        System.out.println(strings);
    }
}