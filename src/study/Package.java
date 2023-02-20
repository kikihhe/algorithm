package study;

import java.util.Scanner;

// 背包问题,dp解法
public class Package {
    //01背包的测试用例
//6 3
//3 5
//2 4
//4 2
// 9

//10 4
//2 1
//3 3
//4 5
//7 9
// 12
    // 使用二维数组完成01背包问题求解。
    public static void main1(String[] args) {
        Scanner s = new Scanner(System.in);
        int capacity = s.nextInt(); // 背包容量
        int n = s.nextInt(); // 物品个数
        int[] weight = new int[n+1]; // 每个物品的重量,下标从1开始
        int[] value = new int[n+1]; // 每个物品的价值,下标从1开始
        for (int i = 1; i <= n; i++) {
            weight[i] = s.nextInt();
            value[i] = s.nextInt();
        }
        int[][] dp = new int[n+1][capacity+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) {
                // 如果不拿这个物品，那么直到这个物品，所获得的最大价值就是上一个物品的最大价值
                dp[i][j] = dp[i - 1][j];
                // 如果剩余的空间可以拿这个物品，就在“拿”与“不拿”所产出的最大价值中选出最大的
                if (j >= weight[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        System.out.println(dp[n][capacity]);

    }
    // 使用一维数组完成01背包问题
    public static void main2(String[] args) {
        Scanner s = new Scanner(System.in);
        int capacity = s.nextInt(); // 背包容量
        int n = s.nextInt(); // 物品个数
        int[] weight = new int[n+1]; // 每个物品的重量,下标从1开始
        int[] value = new int[n+1]; // 每个物品的价值,下标从1开始
        for (int i = 1; i <= n; i++) {
            weight[i] = s.nextInt();
            value[i] = s.nextInt();
        }

        int[] dp = new int[capacity + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = capacity; j >= 1; j--) {
                // 如果不拿这个物品，那么直到这个物品，所获得的最大价值就是上一个物品的最大价值
//                dp[j] = dp[j];
                // 如果拿这个物品，那么最大价值就是在“拿”与“不拿”所产出的最大价值中选出最大的
                if (j >= weight[i]) {
                    dp[j] = Math.max(
                            dp[j],
                            dp[j - weight[i]]+value[i]);
                }

            }
        }
        System.out.println(dp[capacity]);
    }

//10 4
//2 1
//3 3
//4 5
//7 9
    // 完全背包问题: 每一个物品都可拿无数次
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int capacity = s.nextInt(); // 背包容量
        int n = s.nextInt(); // 物品个数
        int[] weight = new int[n+1]; // 每个物品的重量,下标从1开始
        int[] value = new int[n+1]; // 每个物品的价值,下标从1开始
        for (int i = 1; i <= n; i++) {
            weight[i] = s.nextInt();
            value[i] = s.nextInt();
        }

        int[] dp = new int[capacity + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (j >= weight[i]) {
                    dp[j] = Math.max(
                            dp[j], // 这个物品不拿的最大价值
                            dp[j - weight[i]] + value[i]); // 这个物品拿的最大价值
                }
            }
        }
        System.out.println(dp[capacity]);
    }

}
