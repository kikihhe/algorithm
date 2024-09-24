package com._京东._2;

import java.util.Arrays;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = scanner.nextInt();
            cars[i][1] = scanner.nextInt();
        }
        System.out.println(removeCount(cars));
    }
    private static int removeCount(int[][] cars) {
        // 按照位置排序
        Arrays.sort(cars, (a, b) -> a[0] - b[0]);
        int removeCount = 0;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i + 1][1] < cars[i][1]) {
                removeCount++;
            }
        }
        return removeCount;
    }
}