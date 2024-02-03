package com.xiaohe.递归回溯剪枝.不同路径Ⅲ;

public class Solution {
    private int ret;
    private int beginX;
    private int beginY;
    /**
     * 总共需要走多少步才可以统计结果
     */
    private int step;
    private boolean[][] used;

    private int[] dx = new int[]{1, -1, 0, 0};
    private int[] dy = new int[]{0, 0, 1, -1};

    public int uniquePathsIII(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    beginX = i;
                    beginY = j;
                } else if (arr[i][j] == 0) {
                    step++;
                }
            }
        }
        used = new boolean[arr.length][arr[0].length];
        // step也算上初始和结束
        step += 2;
        // 走第一步
        used[beginX][beginY] = true;
        process(arr, beginX, beginY, 1);
        return ret;
    }

    /**
     * @param arr
     * @param i     当前x位置
     * @param j     当前y位置
     * @param count 当前走了多少步
     */
    private void process(int[][] arr, int i, int j, int count) {
        // 如果走到了终点
        if (arr[i][j] == 2) {
            if (count == step) {
                ret++;
            }
            return;
        }
        // 走到中间某个位置
        for (int k = 0; k < dx.length; k++) {
            // 找到下一步要走的下标
            int x = i + dx[k];
            int y = j + dy[k];
            // 如果越界了，不走
            if (x < 0 || x >= arr.length || y < 0 || y >= arr[0].length) {
                continue;
            }
            // 如果走过了或者不能走，不走
            if (used[x][y] || arr[x][y] == -1) {
                continue;
            }
            used[x][y] = true;
            process(arr, x, y, count + 1);
            used[x][y] = false;
        }
    }

    public static void main(String[] args) {
//        [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
        int[][] arr = new int[][] {
                {1,0,0,0},
                {0,0,0,0},
                {0,0,0,2}
        };
        System.out.println(new Solution().uniquePathsIII(arr));
    }
}