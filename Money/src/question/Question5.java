package question;

import java.util.Scanner;


public class Question5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string 1: ");
        String str1 = scanner.next();
        System.out.print("Enter string 2: ");
        String str2 = scanner.next();

        int i = 0;
        int j = 0;
        for (int k = 0; k < str1.length() + str2.length(); k++) {
            if (i < str1.length()) {
                System.out.print(str1.charAt(i));
                i++;
            }
            if (j < str2.length()) {
                System.out.print(str2.charAt(j));
                j++;
            }
        }
    }
}
