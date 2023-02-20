package study;

import java.util.Scanner;

/**
     假设有排成一行的N个位置，记为1~N，开始时机器人在M位置，机器人可以往左或者往右走.
     如果机器人在1位置，那么下一步机器人只能走到2位置，如果机器人在N位置，那么下一步机器人只能走到N-1位置。
     规定机器人只能走k步，最终能来到P位置的方法有多少种。由于方案数可能比较大，所以答案需要对1e9+7取模。
 */
public class Test2 {
    private static final int mod = (int) 1e9+7;
    static int[][] cache = null;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();// 总共有多少个位置, 1 - N
        int M = s.nextInt();// 机器人现在所在的位置
        int K = s.nextInt();// 剩余步数
        int P = s.nextInt();// 目标位置
        cache = new int[N + 1][K + 1]; // 缓存
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= K; j ++) {
                cache[i][j] = -1;
            }
        }
        int result = way(N, M, K, P);

        System.out.println(result);
        System.out.println(result % mod);


    }
    private static int way(int N, int M, int K, int P) {
        if (cache[M][K] != -1) {
            return cache[M][K];
        }
        // 如果剩余步数为0，看现在是否已经到达目标位置
        if (K == 0) {
            cache[M][K] = M == P ? 1: 0;
            return cache[M][K];
        }
        // 如果走到了1位置，只能往2走
        if (M == 1) {
            cache[M][K] = way(N, 2, K - 1, P);
            return cache[M][K] ;
        }
        // 如果走到了N位置，只能往N - 1位置走
        if (M == N ) {
            cache[M][K] = way(N, N - 1, K - 1, P);
            return cache[M][K];
        }
        // 如果此时在中间，且还有步数可以走，可以往左走也可以往右走
        cache[M][K] = way(N, M - 1, K - 1, P) +
                      way(N, M + 1, K - 1, P);
        return cache[M][K];

    }
}
