package question;

import java.util.Scanner;


public class Question2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter search word: ");
        String word = scanner.next();

        System.out.print("Enter string to test: ");
        String test = scanner.nextLine();

        if (test.startsWith(word)) {
            System.out.println("Starts with " + word);
        } else {
            System.out.println("Does not start with " + word);
        }

    }
}
