package 包含min函数的栈;

import java.util.Stack;

/**
 * @ClassName Main
 * @Description TODO
 * @Author 何
 * @Date 2023-06-12 10:12
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {

    }
}
class MinStack {
    private Stack<Integer> a;
    private Stack<Integer> b;


    /** initialize your data structure here. */
    public MinStack() {
        a = new Stack<>();
        b = new Stack<>();
    }

    public void push(int x) {
        if (b.isEmpty()) {
            b.push(x);
        } else {
            if (x <= a.peek()) {
                b.push(x);
            }
        }
        a.push(x);
    }

    public void pop() {
        int pop = a.pop();
        if (pop == b.peek()) {
            b.pop();
        }
    }

    public int top() {
        return a.peek();
    }

    public int min() {
        return b.peek();
    }
}
