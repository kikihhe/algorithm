package com._美团._2;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 物品个数
        int n = in.nextInt();
        // 标签种类
        int m = in.nextInt();
        // 每个物品适合的标签种类
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = in.nextInt();
        }

        // 每个物品贴上适合标签后的美观值
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
        }
        // 每个物品未贴上适合标签的美观值
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = in.nextInt();
        }

        System.out.println(dfs(n, m, a, b, c));

    }

    private static int dfs(int n, int m, int[] a, int[] b, int[] c) {
        int[][] dp = new int[n][m];
        for (int j = 0; j < m; j++) {
            if (j == a[0]) {
                dp[0][j] = b[0];
            } else {
                dp[0][j] = c[0];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == a[i]) {
                    int max = dp[i - 1][j] + b[i];
                    for (int k = 0; k < m; k++) {
                        max = Math.max(max, dp[i - 1][k] + c[i]);
                    }
                    dp[i][j] = max;
                } else {
                    dp[i][j] = dp[i-1][j] + c[i];
                }
            }
        }
        int maxValue = dp[n-1][0];
        for (int j = 1; j < m; j ++) {
            maxValue = Math.max(maxValue, dp[n-1][j]);
        }
        return maxValue;
    }
}