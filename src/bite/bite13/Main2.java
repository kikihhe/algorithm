package bite.bite13;

import java.util.*;
// 跳石板
// 题目链接: https://www.nowcoder.com/practice/4284c8f466814870bae7799a07d49ec8
/*
小易来到了一条石板路前，每块石板上从1挨着编号为：1、2、3.......
这条石板路要根据特殊的规则才能前进：对于小易当前所在的编号为K的 石板，小易单次只能往前跳K的一个约数(不含1和K)步，即跳到K+X(X为K的一个非1和本身的约数)的位置。
小易当前处在编号为N的石板，他想跳到编号恰好为M的石板去，小易想知道最少需要跳跃几次可以到达。
例如：
N = 4，M = 24：
4->6->8->12->18->24
于是小易最少需要跳跃5次，就可以从4号石板跳到24号石板
*/
public class Main2 {
    public static void main(String[] a) {
        Scanner s = new  Scanner(System.in);
        // N为当前所处位置
        int N = s.nextInt();
        // M为目标位置
        int M = s.nextInt();
        int[] dp = new int[M + 1];

        for(int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[N] = 0;
        for(int i = N; i <= M; i++) {
            // 证明无法跳到这个台阶，直接去下一个看.
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }
            // 代表i的所有因数
            List<Integer> factor = func(i);
            for (int k : factor) {
                if (i + k <= M) {
                    dp[i+k] = Math.min(dp[i+k], dp[i] + 1);
                }
            }
        }
        System.out.println(dp[dp.length - 1] == Integer.MAX_VALUE ? -1 : dp[dp.length - 1]);

    }

    // 计算N的所有约数
    private static List<Integer> func(int N) {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                list.add(i);
                if (N / i != i) {
                    list.add(N / i);
                }
            }
        }
        return list;
    }
}