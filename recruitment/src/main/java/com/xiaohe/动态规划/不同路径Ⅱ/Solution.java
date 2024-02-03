package com.xiaohe.动态规划.不同路径Ⅱ;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 不同路径Ⅲ是一道递归、回溯算法。
 */
class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];
        for (int i = 0; i < dp.length; i++) {
            if (arr[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }
        for (int i = 0; i < dp[0].length; i++) {
            if (arr[0][i] == 1) {
                break;
            }
            dp[0][i] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (arr[i][j] != 1) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[arr.length - 1][arr[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] {
                {0, 0, 0},
                {1, 0, 0},
                {0, 0, 0}
        };
        System.out.println(new Solution().uniquePathsWithObstacles(arr));
    }
}