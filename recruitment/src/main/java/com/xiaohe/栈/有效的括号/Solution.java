package com.xiaohe.栈.有效的括号;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 */
public class Solution {
    public boolean isValid(String s) {
        // 左括号压入栈中，右括号从栈中取出一个左括号进行匹配
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(' || arr[i] == '[' || arr[i] == '{') {
                stack.add(arr[i]);
            } else {
                if (stack.isEmpty()) return false;
                char peek = stack.peek();
                if (arr[i] == ')' && peek != '(') {
                    return false;
                }
                if (arr[i] == ']' && peek != '[') {
                    return false;
                }
                if (arr[i] == '}' && peek != '{') {
                    return false;
                }
                stack.pop();
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "([)]";
        System.out.println(new Solution().isValid(str));
    }
}
