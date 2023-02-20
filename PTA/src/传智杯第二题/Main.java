package 传智杯第二题;


import java.util.Scanner;
import java.util.Stack;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-11-26 15:35
 */
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> answer = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack1.push(s.nextInt());
        }
        for (int j = 0; j < m; j++) {
            stack2.push(s.nextInt());
        }
        Stack<Integer> temp = new Stack<>();
        if(stack1.size() < stack2.size()) {
            temp = stack1;
            stack1 = stack2;
            stack2 = temp;
        }
        int max = Math.max(m,n);

        int min = Math.min(n,m);
        int t = 0;
        int i = 1;
        int a = 0;
        int b = 0;
        for (; i <= min; i++) {
            a = stack1.pop();
            b = stack2.pop();
            int now = (a + b + t) % (i + 1);
            answer.push(now);
            t = (a + b) / (i + 1);
        }
        for(; i <= max; i++) {
             a = stack1.pop();
            int now = (a  + t) % (i + 1);
            answer.push(now);
            t = (a + t) / (i + 1);

        }
        if(t != 0) {
            answer.push(t);
        }
        i = answer.size() - 1;
        while(i >= 0) {
            System.out.print(answer.get(i) + " ");
            i--;
        }

    }
}
