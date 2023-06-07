package 题目.第四题;


import java.util.Scanner;

public class Main {
    public static String find(String string) {
        // 直接比较(其实底层使用ascii码进行比较)
        char max = '\0';

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) > max) {
                max = string.charAt(i);
            }
        }
        return max + "(max)";
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 使用scanner.hasNext判断是否还有输入，按enter结束。
        while(scanner.hasNext()) {
            String string = scanner.next();
            String s = find(string);
            System.out.println(s);
        }

    }
}
