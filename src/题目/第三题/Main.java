package 题目.第三题;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    // 先判断输入的是不是期望的括号
    public static boolean isKuohao(char c) {
        if (c == '(' || c == ')' || c == '[' || c == ']' || c == '{' || c == '}') {
            return true;
        }
        return false;
    }

    public static boolean IsCompare() {
        Stack<Character> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        // 读入字符串
        String s = sc.next();
        char[] chars = s.toCharArray();

        // 遍历给定的字符串
        for (int i = 0; i < chars.length; i++) {
            char flag = chars[i];
            // 如果不是括号，跳过
            if (isKuohao(flag)) {
                // 如果是括号，分为两种:
                // 1. 左括号: ( [ { ，直接放入栈中
                // 2. 右括号: ) ] } ，从栈中弹出一个符号，看看是不是该右括号对应的左括号
                if (flag == '(' || flag == '{' || flag == '[') {
                    stack.push(flag);
                } else {
                    // 到这里说明为右括号，先判断栈中有没有左括号，如果栈中没有左括号，说明出现了这种情况: )
                    // (就是只出现了一个右括号)
                    if (stack.empty()) {
                        System.out.println("右括号过多");
                        return false;
                    } else if (flag == '}' && stack.peek() == '{' || flag == ')' && stack.peek() == '(' || flag == ']' && stack.peek() == '[') {
                        // 如果确实匹配，将栈中的左括号弹出
                        stack.pop();
                    } else {
                        // 不匹配，返回false;
                        System.out.println("右括号不能匹配左括号");
                        return false;
                    }
                }
            }
        }
        if (stack.empty()) {
            return true;
        } else {
            System.out.println("左括号过多");
            return false;
        }
    }

    public static void main(String[] args) {
        int flage = 0;
        Scanner sc = null;
        while (flage == 0) {
            boolean b = IsCompare();
            System.out.println("匹配与否：" + b);
            System.out.println("是否继续测试：" +
                    "0:继续");
            sc = new Scanner(System.in);
            flage = sc.nextInt();
        }
    }

}
