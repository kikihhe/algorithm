package FBI树;

import java.util.Scanner;

/**
 * @ClassName Main
 * @Description FBI树
 * @Author 何
 * @Date 2023-08-14 12:06
 * @Version 1.0
 *
 * 一个字符串，如果长度是1，直接解析为 I、B、F其中一个，然后return
 * 如果长度不是1, 分为左右两边，递归左边，然后递归右边
 *
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String str = scanner.next();
        StringBuilder result = new StringBuilder("");
        process(str, result);
        System.out.println(result);


    }
    // 判断str是FBI其中的哪一种


    private static void process(String str, StringBuilder result) {
        if (str.length() == 1) {
            String judge = judge(str);
            result.append(judge);
            return ;
        }
        // 长度大于1，分为左右两边
        String left = str.substring(0,str.length()/2);
        String right = str.substring(str.length()/2, str.length());
        process(left, result);
        process(right, result);
        String s = judge(str);
        result.append(s);
    }

    private static String judge(String str) {
        char[] arr = str.toCharArray();
        int a = 0;
        for (int i = 0; i < arr.length; i++) {
            a += (arr[i] - '0');
        }
        if (a == arr.length) return "I";
        else if (a == 0) {
            return "B";
        } else {
            return "F";
        }
    }
}
