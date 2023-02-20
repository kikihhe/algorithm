package study;

import java.util.HashMap;
import java.util.Map;

public class Test3 {
    // arr: 所有面值的货币
    // index: 当前到哪一个面值的货币了
    // rest: 剩余目标
    public static int process(int[] arr, int index, int rest) {
        if (rest == 0) return 1;
        // 已经没有货币能遍历了
        // 1: 剩余目标正好为0，说明这个方案能行
        // 2: 剩余目标还没完成，说明方案不行，返回0
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }
        int result = 0;
        // i代表使用当前货币多少张
        for (int i = 0; i * arr[index] <= rest ; i++) {
            result += process(arr, index+ 1, rest - i * arr[index]);
        }
        return result;
    }


    public static int ways(int[] arr, int aim) {
        return process(arr, 0, aim);
    }

    // 动态规划
    public static int ways2(int[] arr, int aim) {

        // 初始化数组
        int[][] dp = new int[arr.length+1][aim+1];
        dp[arr.length][0] = 1;

        for (int index = arr.length - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                dp[index][rest] = dp[index+1][rest];
                if (rest - arr[index] >= 0) {
                    dp[index][rest] += dp[index][rest - arr[index]];
                }
            }
        }
        return dp[0][aim];
    }


    public static void main(String[] args) {
        int[] arr = new int[]{5,10, 50, 100};
        System.out.println(ways2(arr, 1000));


    }
}
