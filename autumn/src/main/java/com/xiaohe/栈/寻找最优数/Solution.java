package com.xiaohe.栈.寻找最优数;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 题目:
 * 在给定数组中找到这样的特殊数: 它的左边都是比它小的数，它的右边都是比它大的数
 * 这样的数可能有多个，全部返回
 */
public class Solution {
    public List<Integer> find(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int now = arr[i];
            // 如果栈中的数比当前数小，把栈中的数弹出
            while (!stack.isEmpty() && now < stack.peek()) {
                stack.pop();
            }
            // 如果当前值比最大值还大，有资格进入栈
            if (now > max) {
                stack.push(now);
                max = now;
            }
        }
        return new ArrayList<>(stack);
    }
}
