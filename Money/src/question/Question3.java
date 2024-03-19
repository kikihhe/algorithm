package question;

import java.util.Arrays;
import java.util.Scanner;


public class Question3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter String: ");
        String str = scanner.nextLine();
        char[] arr = str.toCharArray();

        int begin = 0;
        int end = arr.length - 1;
        boolean flag = false;
        while (begin < end && arr[begin] == arr[end]) {
            begin++;
            end--;
            flag = true;
        }
        if (flag) {
            char[] chars = Arrays.copyOf(arr, begin);
            System.out.println("String begins and ends with " + new String(chars));
        } else {
            System.out.println("String does not begin and end the same");
        }

    }
}
