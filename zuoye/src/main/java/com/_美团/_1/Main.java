package com._美团._1;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    // 1 ：1
    // 2 ：2
    // 3 ：3
    // 4 ：4
    // 5 ：4
    // 6 ：0 0 0 0 0 0 // 5
    // 7 ：0 0 0 0 0 0 0 // 5
    // 8 ：0 0 0 0 0 0 0 0 // 5
    // 9 ：0 0 0 0 0 0 0 0 0  // 5
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(process(n));
    }

    private static int process(int n) {
        if (n <= 4) return n;
        // 此次染色多少个
        int count = 1;
        int result = 2;
        // 已经染色多少了
        int now = 2;
        while (now < n) {
            count = now - 1;
            now += count;
            result ++;
        }
        return result;
    }
}