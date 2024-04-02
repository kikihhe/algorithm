package com.xiaohe.递归回溯剪枝.岛屿的最大面积;

class Solution {
    /**
     * 解题思路 :
     * 当遍历到 grid[i][j] = 1 时，可以进入 dfs，向其四周遍历岛屿，注意终止条件不止有边界，已经遍历过的位置不要重复遍历
     * sum 为成员变量，每次遍历结束统计 sum 的最大值后将其置为0重新遍历
     */
    int sum = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    max = Math.max(max, sum);
                    sum = 0;
                }
            }
        }
       return max;
    }
    public void dfs(int[][] grid, int i, int j) {
        // 如果越界
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }
        // 如果已经遍历过，或者这里根本不是岛屿
        if (grid[i][j] == 0) {
            return;
        }
        // 走到这里说明这里是岛屿，sum++，并将此位置变为0，防止重复遍历
        grid[i][j] = 0;
        sum++;
        // 向其四周遍历
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
    }
}