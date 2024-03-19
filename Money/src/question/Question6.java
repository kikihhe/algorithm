package question;

import java.util.Scanner;

public class Question6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text to check ");
        String str = scanner.nextLine();

        int count = findConsecutiveTriples(str);
        System.out.println("There are " + count + " character triples in text");
    }

    public static int findConsecutiveTriples(String input) {
        int result = 0;
        char[] arr = input.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            for (int j = i; j < arr.length - 1; j++) {
                if (arr[j] == arr[j + 1]) {
                    count++;
                    if (count == 3) {
                        result++;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return result;
    }
}

