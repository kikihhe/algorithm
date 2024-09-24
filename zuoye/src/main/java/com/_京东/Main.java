package com._京东;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(process(k, arr));
    }
    private static int process(int k, int[] arr) {
        int groupCount = 1;
        int maxValue = arr[0];
        int minValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - maxValue <= k && maxValue - arr[i] <= k) {
                maxValue = Math.max(maxValue, arr[i]);
                minValue = Math.min(minValue, arr[i]);
            } else {
                // 不能放进当前组，新开一组
                groupCount++;
                maxValue = arr[i];
                minValue = arr[i];
            }
        }
        return groupCount;
    }
}