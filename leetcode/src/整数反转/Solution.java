package 整数反转;

import java.util.Scanner;

class Solution {
    public int reverse(int x) {
        char[] arr = String.valueOf(x).toCharArray();
        String str = func(arr);

        if (str.compareTo(Integer.MAX_VALUE +"") > 0 || str.charAt(0) == '-' && str.substring(1, str.length()).compareTo(Integer.MAX_VALUE+"") > 0) {
            return 0;
        }


        return Integer.parseInt(str);
    }
    private String func(char[] arr) {
        // - 4 2 2
        int i = 0;
        if (arr[0] == '-' || arr[0] == '+') {
            i++;
        }
        int j = arr.length - 1;
        while(j >= i && arr[j] == '0') {
            j--;
        }
        String str = "";
        if (arr[0] == '-' || arr[0] == '+') {
            str += arr[0];
        }
        while (j >= i) {
            str += arr[j];
            j--;
        }

        return str;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int reverse = s.reverse(123);
        System.out.println(reverse);
    }
}