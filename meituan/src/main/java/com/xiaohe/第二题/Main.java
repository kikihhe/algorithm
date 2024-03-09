package com.xiaohe.第二题;

import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2024-03-09 10:13
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 数组大小
        int n = scanner.nextInt();
        // 询问次数
        int q = scanner.nextInt();

        // 和
        long sum = 0;
        int count0 = 0;
        for (int i = 0; i < n; i++) {
            int nextInt = scanner.nextInt();
            sum += nextInt;
            if (nextInt == 0) {
                count0++;
            }
        }
        // q次
        for (int i = 0; i < q; i++) {
            long l = scanner.nextInt();
            long r = scanner.nextInt();
            long min = sum + count0 * l;
            long max = sum + count0 * r;
            System.out.println(min + " " + max);

        }


    }
}
