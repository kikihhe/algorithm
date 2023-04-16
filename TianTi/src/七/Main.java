package 七;

import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-04-16 13:57
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] map = new int[n+1][m+1];
        int Q = scanner.nextInt();
        for (int i = 0; i < Q; i++) {
            // T表示BOSS选择的是行还是列
            // 如果是0，表示行
            // 如果是1，表示列
            int T = scanner.nextInt();

            // C表示行号/列号，从1开始
            int C = scanner.nextInt();
            process(n,m,T,C, map);

        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == 0) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    // n: 行数
    // m: 列数
    // t: BOSS的攻击效果
    // c: BOSS攻击的行/列
    // map: 地图
    private static void process(int n, int m, int t, int c, int[][] map) {
        // 攻击的是行
        if (t == 0) {
            for (int i = 1; i <= m; i++) {
                map[c][i] = 1;
            }

        } else {
            // 攻击的是列
            for (int i = 1; i <= n; i++) {
                map[i][c] = 1;
            }
        }

    }
}
