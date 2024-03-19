package question;

import java.util.Scanner;


public class Question7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text to check ");
        String str = scanner.nextLine();
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) - '0' >= 0 && str.charAt(i) - '0' <= 9) {
                sum += (str.charAt(i) - '0');
            }
        }
        System.out.println("Sum of digits in string: " + sum);

    }
}
