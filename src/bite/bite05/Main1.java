package bite.bite05;

import java.util.*;

public class Main1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str1 = s.next();
        String str2 = s.next();
        int count = 0;
        for (int i = 0; i < str1.length(); i ++) {
            StringBuilder sb = new StringBuilder(str1);
            StringBuilder insert = sb.insert(i, str2);
            // 判断insert是不是回文串
            if (isH(insert)) {
                count ++;
            }
        }
        System.out.println(count);
    }

    private static boolean isH(StringBuilder insert) {
        String s = insert.toString();
        char[] arr = s.toCharArray();
        for (int i = 0, j = arr.length - 1; i < j; i ++, j--) {
            if (arr[i] != arr[j]) {
                return false;
            }
        }
        return true;
    }
}