package 活跃度;

import java.util.*;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-04-04 22:26
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = scanner.nextInt();
        }
        Arrays.sort(list);

        int size = list.length;
        // 前一部分人的分数
        int a1 = 0;
        // 后一部分人的分数
        int a2 = 0;
        int x1 = N/2;
        int x2 = N/2;
        for (int i = 0; i < N/2; i++) {
            a1+=list[i];
            a2 += list[size/2+i];


        }
        if (N%2 == 1) {
            a2+= list[size-1];
            x2++;
        }

        System.out.println("Outgoing #: " + (x1) + "\n" +
                "Introverted #: " + (x2) + "\n" +
                "Diff = " + (a2-a1) +  "\n");


    }
}
