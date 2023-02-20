package study;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = s.next();
        }
        
        boolean flag1 = first(strs);
        boolean flag2 = second(strs);
        if (!flag1 && !flag2) {
            System.out.println("none");
        } else if (flag1 && !flag2) {
            System.out.println("lexicographically");
        } else if (!flag1 && flag2) {
            System.out.println("lengths");
        } else {
            System.out.println("both");
        }
    }
    // 第一种方法
    private static boolean first(String[] strs) {
        for (int i = 0; i < strs.length - 1; i++) {
            if (strs[i].compareTo(strs[i+1]) > 0) {
                return false;
            }
        }
        return true;
    }
    // 第二种方法
    private static boolean second(String[] strs) {
        for (int i = 0; i < strs.length-1; i++) {
            if (strs[i].length() > strs[i+1].length()) {
                return false;
            }
        }
        return true;
    }


}