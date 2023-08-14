package 单词方阵;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Main
 * @Description 单词方阵
 * @Author 何
 * @Date 2023-08-14 14:21
 * @Version 1.0
 */
public class Main {
    private static String str = "yizhong";
    private static boolean[][] dp;
    private static int[] dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    private static int[] dy = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char[][] arr = new char[n][n];
        dp = new boolean[n][n];


        for (int i = 0; i < n; i++) {
            arr[i] = scanner.next().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 'y') {
                    process(arr, i, j, 0, new int[7][2]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j]) System.out.print(arr[i][j]);
                else System.out.print("*");
            }
            System.out.println();
        }

    }


    /**
     * @param arr
     * @param x     当前行
     * @param y     当前列
     * @param index 匹配到第几个了
     * @param visit 走过的路径 visit = new int[7][2], visit[i][0] : 符合条件的点的行，visit[i][1]:符合条件的点的列
     */
    private static void process(char[][] arr, int x, int y, int index, int[][] visit) {
        // 判断是否越界
        if (x < 0 || y < 0 || x >= arr.length || y >= arr.length) return;
        // 如果遍历完了
        if (index == str.length() - 1) {
            // 将visit数组中的值标记到dp中
            ranse(visit);
            return;
        }
        if (arr[x][y] != str.charAt(index)) {
            return;
        }
        // 如果等于, 记录当前路径，朝八个方向遍历
        visit[index][0] = x;
        visit[index][1] = y;
        for (int i = 0; i < 8; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            // 筛选条件
            if (newX < 0 || newY < 0 || newX >= arr.length || newY >= arr.length) {
                continue;
            }
            if (index > 0 && (newX == visit[index - 1][0] && newY == visit[index - 1][1])) {
                continue;
            }
            process(arr, newX, newY, index + 1, Arrays.copyOf(visit, visit.length));
        }

    }


    private static void ranse(int[][] visit) {
        for (int i = 0; i < visit.length; i++) {
            dp[visit[i][0]][visit[i][1]] = true;
        }
    }
}

