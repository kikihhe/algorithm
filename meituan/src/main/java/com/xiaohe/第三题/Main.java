package com.xiaohe.第三题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2024-03-09 11:11
 *
 * 4
 * 1010
 * 0101
 * 1100
 * 0011
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = 210;
        char[][] c = new char[N][N];
        // 记录1的数量
        int[][] s = new int[N][N];

        int n = 0;
        // 记录每一行结果数
        int[] res = new int[N];

        n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            String str = scanner.next();
            System.arraycopy(str.toCharArray(), 0, c[i], 1, str.length());

        }
        // dp
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (c[i][j] == '1') {
                    s[i][j]++;
                }
                s[i][j] += s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k + i <= n && k + j <= n; k += 2) {
                    int temp = s[k + i][k + j] - s[i - 1][k + j] - s[k + i][j - 1] + s[i- 1][j-1];
                    if (temp == (k + 1) * (k+1) / 2) {
                        res[k]++;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(res[i]);
        }

    }
}











