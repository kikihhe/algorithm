package 餐馆;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-03-01 19:20
 */
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // n张桌子
        int n = s.nextInt();
        // 每一张桌子
        int[] a = new int[n];
        // m个客人
        int m = s.nextInt();
        // 每一批客人有多少人
        int b[] = new int[m];
        // 每一批客人消费
        int c[] = new int[m];
        // 输入每一张桌子能容纳多少人
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        // 输入每一批客人的人数、消费
        for (int i = 0; i < m; i++) {
            b[i] = s.nextInt();
            c[i] = s.nextInt();
        }
//        // 将桌子大小排序，小在前
//        Arrays.sort(a);
//        // 标记已经坐人的桌子
//        int[] flag = new int[n];
//        // 遍历每一批客人，
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                // 如果已经坐过人，pass
//                if (flag[j] == 1) continue;
//                // 如果没做人，记录
//                if (b[i] <= a[j]) {
//
//                }
//            }
//        }

    }
}
