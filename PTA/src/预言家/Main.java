package 预言家;

import java.util.Scanner;

/**
 * n 个人一起玩狼人杀，按从 1 到 n 的顺序编号，
 * 据说，这群人当中有一个预言家。如果预言家真的存在，
 *      那么： 1）预言家不会信任任何人。 2）每个人（除了预言家）都信任预言家。 最多只有一个人同时满足 1 和 2 。
 * 给定一个数组 trust ，其中 trust[i] = [ai, bi] 表示编号为 ai 的人信任编号为 bi 的人。
 * 如果预言家存在并且可以确定他的身份，请返回预言家的编号；否则，返回 -1 。
 *
 * 提示： 1 <= n <= 1000；0 <= trust.length <= 100；trust[i].length == 2；trust 中的所有trust[i] = [ai, bi] 互不相同；ai != bi；1 <= ai；bi <= n
 */
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] arr = new int[n][2];

        for (int i = 0; i < n - 1; i++) {
            arr[i][0] = s.nextInt();
            arr[i][1] = s.nextInt();
        }

        Main main = new Main();
        int result = main.findProphet(n, arr);
        System.out.println(result);


    }
    public int findProphet(int n, int[][] trust) {
        // 下标代表信任几个人
        int[] s = new int[n + 1];
        // 下标代表被几个人信任
        int[] k = new int[n + 1];
        int result = -1;
        for (int i = 0; i < n - 1; i++) {
            s[trust[i][0]]++;
            k[trust[i][1]]++;
        }
        for (int i = 0; i <= n; i++) {
            if (s[i] == 0 && k[i] == n - 1) {
                result = i;
            }
        }

        return result;
    }
}
