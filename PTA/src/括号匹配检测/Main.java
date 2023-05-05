package 括号匹配检测;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-05-04 20:10
 */
public class Main {
    public static boolean isKuo(char a) {
        if (a == '{' || a == '}' || a == '[' || a == ']' || a == '(' || a == ')') return true;
        return false;
    }
    public static boolean isPiPei(char a, char b) {
        if (a == '{' && b == '}') return true;
        if (a == '[' && b == ']') return true;
        if (a == '(' && b == ')') return true;
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        String str = scanner.next();
        char[] arr = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (!isKuo(arr[i])) {
                continue;
            } else {
                if (arr[i] == '{' || arr[i] == '[' || arr[i] == '(') {
                    stack.push(arr[i]);
                } else {
                    if (stack.isEmpty() && (arr[i] == '}' || arr[i] == ']' || arr[i] == ')')) {
                        break;
                    }
                    char b = stack.peek();
                    if (isPiPei( b, arr[i])) {
                        stack.pop();
                        count++;
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
