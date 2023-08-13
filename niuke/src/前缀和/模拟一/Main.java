package 前缀和.模拟一;

import java.util.Scanner;

/**
 * @ClassName Main
 * @Description 一维前缀和
 * @Author 何
 * @Date 2023-08-13 13:35
 * @Version 1.0
 * 前缀和: 快速得出数组中某一段连续区间的和。
 *
 * 题目 :
 * 输入一个数组，求一段区间内的和
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 数组长度
        int length = scanner.nextInt();
        // 操作次数
        int n = scanner.nextInt();
        int[] arr = new int[length + 1];

        // dp[i] : [1, i] 区间内所有元素的和
        int[] dp = new int[length + 1];
        // 输入
        for (int i = 1; i <= length; i++) {
            arr[i] = scanner.nextInt();
            dp[i] = dp[i - 1] + arr[i];
        }



        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(dp[b] - dp[a-1]);
        }

    }
}
