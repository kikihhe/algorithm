package homework.homework2;

import java.util.Random;
import java.util.Scanner;


public class One {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your last name: ");
        String lastName = scanner.next();
        System.out.println("Please enter your first name: ");
        String firstName = scanner.next();
        Random random = new Random();
        // Use subString to cut the string
        // Generate the number [0,90) and add 10 to generate the number [10, 100)
        String str = lastName.substring(0, 4) + firstName.substring(0, 2) + (random.nextInt(90) + 10);
        System.out.println(str);

    }
}
