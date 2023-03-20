package 谁先倒;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 甲的酒量
        int j = scanner.nextInt();
        // 乙的酒量
        int y = scanner.nextInt();
        // 比多少次
        int N = scanner.nextInt();
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < N; i++) {
            // 甲喊
            int jiahan = scanner.nextInt();
            // 甲划
            int jiahua = scanner.nextInt();
            // 乙喊
            int yihan = scanner.nextInt();
            // 乙划
            int yihua = scanner.nextInt();

            if (jiahua == (jiahan+yihan)) {
                count1++;
            }
            if (yihua == (jiahan+yihan)) {
                count2++;
            }
            if (count1 >= j || count2 >= y) {
                break;
            }
            if (jiahan == yihan) continue;

        }
        if (count1 - j == 0) {
            System.out.println("A");
            System.out.println(count2);
        } else if (count2-y == 0) {
            System.out.println("B");
            System.out.println(count1);
        }
        
    }
}