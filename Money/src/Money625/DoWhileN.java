package Money625;

import java.util.Scanner;
public class DoWhileN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个整数：");
        int n = scanner.nextInt();

        int factorial = 1;
        int i = 1;
        String expression = "1";

        do {
            factorial *= i;
            expression += " * " + i;
            i++;
        } while (i <= n);

        System.out.println(n + "! = " + expression + " = " + factorial);
    }
}


