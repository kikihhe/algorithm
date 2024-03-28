package com.xiaohe.数组.螺旋数组;

import java.util.ArrayList;
import java.util.List;

/*
  给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
  输入 : matrix = [
                    [1,2,3],
                    [4,5,6],
                    [7,8,9]
        ]
  输出：[1,2,3,6,9,8,7,4,5]
 */
class Solution {
    public static void main(String[] args) {
        int[][] arr = new int[][] {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(new Solution().spiralOrder(arr));
    }
    public List<Integer> spiralOrder(int[][] arr) {
        List<Integer> result = new ArrayList<>();
        // 上下左右四个边界
        int up = 0;
        int down = arr.length - 1;
        int left = 0;
        int right = arr[0].length - 1;
        while (true) {
            // 从左到右读取上边界, 如果上边界下移后大于下边界，退出
            for (int i = left; i <= right; i++) result.add(arr[up][i]);
            if (++up > down) break;

            // 从上到下读取右边界, 如果右边界左移后小于左边界，退出
            for (int i = up; i <= down; i++) result.add(arr[i][right]);
            if (--right < left) break;

            // 从右到左读取下边界, 如果下边界上移后小于上边界，退出
            for (int i = right; i >= left; i--) result.add(arr[down][i]);
            if (--down < up) break;

            // 从下到上读取左边界, 如果左边界右移后大于右边界，退出
            for (int i = down; i >= up; i--) result.add(arr[i][left]);
            if (++left > right) break;
        }
        return result;
    }
}