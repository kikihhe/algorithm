package 字符串的最大公因子;

import java.util.Scanner;

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // 公共子串的长度必然是 两个串的长度的公约数。
        int len1 = str1.length();
        int len2 = str2.length();
        for (int i = Math.min(len1, len2); i >= 1; --i) {
            if (len1 % i == 0 && len2 % i == 0) {
                // 证明i是len1和len2的公约数,
                String str = str1.substring(0, i);
                if (check(str, str1) && check(str, str2)) {
                    return str;
                }

            }
        }
        return "";

    }
    // 检查多个str能否拼成str1
    public boolean check(String str, String str1) {
        int n = str1.length() / str.length();
        String temp = "";
        for (int i = 0; i < n; i++) {
            temp += str;
        }
        return temp.equals(str1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();
        String str1 = "ABABABAB";
        String str2 = "ABAB";
        solution.gcdOfStrings(str1, str2);
    }
}