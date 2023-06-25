package Money625;
import java.util.Scanner;


public class WhileN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个整数：");
        int n = scanner.nextInt();

        int factorial = 1;
        int i = 1;
        String expression = "1";

        while (i <= n) {
            factorial *= i;
            expression += " * " + i;
            i++;
        }

        System.out.println(n + "! = " + expression + " = " + factorial);
    }
}


