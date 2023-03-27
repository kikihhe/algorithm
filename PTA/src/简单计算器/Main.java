package 简单计算器;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-03-27 22:41
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //
        int N = scanner.nextInt();
        Stack<Integer> nums = new Stack<>();
        Stack<Character> option = new Stack<>();
        for (int i = 0; i < N; i++) {
            nums.push(scanner.nextInt());
        }
        for (int i = 0; i < N-1; i++) {
            option.push(scanner.next().charAt(0));
        }

            while(!nums.isEmpty()) {
                if (nums.size() == 1 && option.size() == 0) {
                    System.out.println(nums.pop());
                    return;
                }
                int n1 = nums.pop();
                int n2 = nums.pop();
                char op = option.pop();
                if (op == '/' && n1 == 0) {
                    System.out.println("ERROR: " + n2 +"/0");
                    return;
                }
                int num = 0;
                switch (op) {
                    case '+':
                        num = n1 + n2;
                        break;
                    case '-':
                        num = n2 - n1;
                        break;
                    case '*':
                        num = n2 * n1;
                        break;
                    case '/':
                        num = n2 / n1;
                }
                nums.push(num);
            }



    }


}
