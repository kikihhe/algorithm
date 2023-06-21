package 整数反转;

import java.util.Scanner;

class Solution {
    // 比较两个字符串对应的数值类型
    private boolean compareTo(String str1, String str2) {
        if (str1.charAt(0) != '-' && str2.charAt(0) != '-') {
            if (str1.length() != str2.length()) {
                return str1.length() > str2.length();
            } else {
                return str1.compareTo(str2) > 0;
            }
        } else {
            str1 = str1.substring(1, str1.length());
            str2 = str2.substring(1, str2.length());
            if (str1.length() != str2.length()) {
                return str1.length() > str2.length();
            } else {
                return str1.compareTo(str2) > 0;
            }
        }

    }
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE || x == 0) return 0;
        String str = x + "";
        if (x < 0) {
            str = str.substring(1, str.length());
        }
        StringBuilder s = new StringBuilder(str);
        String ss = s.reverse().toString();


        if (x < 0) ss = "-" + ss;

        if (x > 0 && compareTo(ss, Integer.MAX_VALUE+"")) {
            return 0;
        } else if (x < 0 && compareTo(ss, (Integer.MIN_VALUE)+"")) {
            return 0;
        } else {
            return Integer.valueOf(ss);
        }


    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int reverse = solution.reverse(-2143847412);
        System.out.println(reverse);
    }
}