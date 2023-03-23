package LeftPad;

//import java.util.*;
//public class Solution {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        int n = scanner.nextInt();
//        String c = scanner.next();
//        scanner.nextLine();
//        String str = scanner.nextLine();
//
//        if(str.length() > n) {
//            str = str.substring(str.length()-n, str.length());
//            System.out.println(str);
//        } else if (str.length() == n) {
//            System.out.println(str);
//        } else {
//            int x = n - str.length();
//            String temp = "";
//            while(x > 0) {
//                temp += c;
//                x--;
//            }
//            System.out.println(temp + str);
//        }
//    }
//}
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        char c = scanner.next().charAt(0);
        scanner.nextLine();
        String str = scanner.nextLine();

        char[] arr = new char[n];
        int count = 0;
        for (int i = n-1; i >= 0; i--) {
            if (count < str.length()) {
                arr[i] = str.charAt(str.length()-1-count);
                count++;
            } else {
                arr[i] = c;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}