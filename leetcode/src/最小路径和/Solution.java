package 最小路径和;
/*
    给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

    说明：每次只能向下或者向右移动一步。
*/

class Solution {
    // 递归
    public int minPathSum1(int[][] grid) {
        return process1(grid, 0, 0);
    }
    // 第i行第j列
    private int process1(int[][] arr, int i, int j) {
        if (i == arr.length - 1 && j == arr[0].length - 1) {
            return arr[i][j];
        }
        int result = arr[i][j];
        // 走到最下面了，只能向右走
        if (i == arr.length - 1) {
            result += process1(arr, i, j+1);
        } else if (j == arr[0].length - 1) {
            // 走到最右边了，只能向下走
            result += process1(arr, i+1, j);
        } else {
            result += Math.min(process1(arr, i+1, j), process1(arr, i, j+1));
        }
        return result;

    }

    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        dp[m-1][n-1] = grid[m-1][n-1];

        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (i == m-1 && j == n-1) {
                    continue;
                }
                dp[i][j] = grid[i][j];
                if (i == m-1) {
                    dp[i][j] += dp[i][j+1];
                } else if (j == n-1) {
                    dp[i][j] += dp[i+1][j];
                } else {
                    dp[i][j] += Math.min(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }


    public static void main(String[] args) {

    }
}