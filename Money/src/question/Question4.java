package question;

import java.util.Scanner;


public class Question4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter String 1: ");
        String target1 = scanner.next();
        System.out.print("Enter String 2: ");
        String target2 = scanner.next();
        scanner.nextLine();

        System.out.print("Enter String to search: ");
        String str = scanner.nextLine();

        int count1 = count(target1, str);
        int count2 = count(target2, str);
        if (count1 == count2) {
            System.out.println(target1 + " and " + target2 + " occur an equal number of times in sentance");
        } else {
            System.out.println(target1 + " and " + target2 + " occur an not equal number of times in sentance");

        }
    }
    public static int count(String target, String str) {
        int count = 0;
        int index = -1;
        while ((index = str.indexOf(target, index + 1)) != -1 && index < str.length()) {
            count++;
            index = str.indexOf(target, index);
        }
        return count;
    }
}
