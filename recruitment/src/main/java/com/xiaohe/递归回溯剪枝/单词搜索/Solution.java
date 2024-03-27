package com.xiaohe.递归回溯剪枝.单词搜索;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 */
public class Solution {
    // 答案
    private boolean flag = false;
    // 每一个位置是否使用过
    private boolean[][] used;

    public static void main(String[] args) {
        char[][] arr = new char[][] {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCaED";
        System.out.println(new Solution().exist(arr, word));
    }
    public boolean exist(char[][] board, String word) {
        used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                process(board, word, i, j, 0);
            }
        }
        return flag;
    }
    /**
     i : 此时遍历到的纵坐标
     j : 此时遍历到的横坐标
     index : 遍历到 word 的哪一个位置了
     */
    public void process(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            flag = true;
            return ;
        }
        // 已经找到结果了，不用再找了
        if (flag) {
            return;
        }
        // 越界检查
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        if (used[i][j]) {
            return;
        }

        // 如果当前遍历到的数组位置与字符串位置的字符相同，可以使用
        if (board[i][j] == word.charAt(index)) {
            used[i][j] = true;
            // 上
            process(board, word, i - 1, j, index + 1);
            // 左
            process(board, word, i, j - 1, index + 1);
            // 下
            process(board, word, i + 1, j, index + 1);
            // 右
            process(board, word, i, j + 1, index + 1);
            used[i][j] = false;
        }
    }
}