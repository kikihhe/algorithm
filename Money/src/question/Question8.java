package question;


import java.util.Scanner;

public class Question8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text to redact ");
        String text = scanner.nextLine();

        System.out.print("Enter word to preserve ");
        String word = scanner.next();

        System.out.println("Enter redact letter");
        char a = scanner.next().charAt(0);

        String strs[] = text.split(" ");
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals(word)) {
                continue;
            } else {
                char[] arr = strs[i].toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    arr[j] = a;
                }
                strs[i] = new String(arr);
            }
        }
        for (int i = 0; i < strs.length; i++) {
            System.out.print(strs[i] + " ");

        }

    }


}


