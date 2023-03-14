package 福到了;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String c = scanner.next();
        int N = scanner.nextInt();
        String[] str = new String[N];
        String[] str1 = new String[N];
        String temp = scanner.nextLine();
        for (int i = 0; i < N; i++) {
            str[i] = scanner.nextLine();
            str1[N-i-1] = new StringBuffer(str[i]).reverse().toString();
//            str1[N - 1 - i] = str1[N - 1 - i].replace("@", c);
        }
        if (Arrays.equals(str, str1)) {
            System.out.println("bu yong dao le");
        }
        for (int i = 0; i < N; i++) {
            str1[N - 1 - i] = str1[N - 1 - i].replace("@", c);

        }
        for (int i = 0; i < N; i++) {
            System.out.println(str1[i]);
        }



    }
}