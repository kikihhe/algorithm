package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 7
 * AABABAB
 *
 * 6
 */
public class Main2 {
    private static int max = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        int a = 0;
        int b = 0;
        for (int i = 0 ; i < str.length(); i++) {
            if (str.charAt(i) == 'A') {
                a++;
            } else {
                b++;
            }
        }
        System.out.println(Math.min(a, b) * 2);
    }

//    /**
//     *
//     * @param arr
//     * @param a 现在a的人数
//     * @param b 现在b的人数
//     */
//    private static void process(char[] arr, int a, int b, int index) {
//        if (index >= arr.length) {
//            if (a == b) {
//                max = Math.max(max, a + b);
//            }
//            return;
//        }
//        // 到了index这个位置，要么选，要么不选
//        for (int i = index; i < arr.length; i++) {
//            // 不选
//            process();
//        }
//    }



}
