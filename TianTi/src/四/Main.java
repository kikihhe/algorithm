package 四;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int x = a + b;
        int result = 1;
        for (int i = 1; i <= (a+b); i++) {
            result *= i;
        }
        if (a+b == 0) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}