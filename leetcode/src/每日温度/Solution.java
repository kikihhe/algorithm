package 每日温度;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] arr = new int[temperatures.length];
        if (temperatures == null || temperatures.length == 0 ) return arr;

        // 维护一个栈, 此栈存储的是下标
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        for (int i = 1; i < temperatures.length; i++) {
            int temperature = temperatures[i];
            // 如果栈不为空，并且栈外的温度比栈顶的温度高，将栈顶的温度取出
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                arr[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return arr;

    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[] {73,74,75,71,69,72,76,73};

        int[] ints = s.dailyTemperatures(arr);
        System.out.println(Arrays.toString(ints));
    }
}