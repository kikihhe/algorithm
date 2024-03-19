package question;

import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
        System.out.print("Enter String:");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char[] charArray = str.toCharArray();
        char temp = charArray[charArray.length - 2];
        charArray[charArray.length - 2] = charArray[charArray.length - 1];
        charArray[charArray.length - 1] = temp;

        System.out.println("result:" + new String(charArray));
    }
}
