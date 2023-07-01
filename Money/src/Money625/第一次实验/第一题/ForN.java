package Money625.第一次实验.第一题;


import java.util.Scanner;
public class ForN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个整数：");
        int n = scanner.nextInt();

        int factorial = 1;
        String expression = "1";

        for (int i = 2; i <= n; i++) {
            factorial *= i;
            expression += " * " + i;
        }

        System.out.println(n + "! = " + expression + " = " + factorial);
    }
}


