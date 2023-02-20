package A减B;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str1 = s.nextLine();
        String str2 = s.nextLine();
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char i : arr2) {
            set.add(i);
        }
        for (int i = 0; i < arr1.length; i++) {
            if(!set.contains(arr1[i])) {
                System.out.print(arr1[i]);
            }

        }
    }
}