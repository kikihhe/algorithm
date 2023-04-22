package 正式.T5;

import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-04-22 13:47
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 帽子的个数: N
        // 同时也是人数
        int N = scanner.nextInt();

        // 帽子颜色
        // 1: 黑色
        // 2: 黄色
        int[] maozi = new int[N];
        for (int i = 0; i < N; i++) {
            maozi[i] = scanner.nextInt();
        }

        int K = scanner.nextInt();

        for (int i = 0; i < K; i++) {
            // 是否有人猜
            boolean isCai = false;
            int wrongCount = 0;
            int rightCount = 0;
            for (int j = 0; j < N; j++) {
                // 这个人猜的帽子颜色
                int a = scanner.nextInt();
                // 如果a为0，代表不猜
                if (a == 0) {

                } else {
                    // 他猜了
                    isCai = true;
                    if (a == maozi[j]) {
                        rightCount++;
                    } else {
                        wrongCount++;
                    }
                }
            }
            if (i != 0) {
                System.out.println();
            }
            // 猜完一轮了
            if (wrongCount == 0 && rightCount >= 1) {
                System.out.print("Da Jiang!!!");
            } else if (!isCai || wrongCount > 0) {
                System.out.print("Ai Ya");
            }
        }

    }
}
