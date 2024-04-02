package 虾皮笔试;

import java.util.*;


public class Solution {
    public static void main(String[] args) {
        int[] costs = new int[] {2, 1, 3, 4, 5};
        int coins = 10;
        System.out.println(new Solution().solution(costs, coins));
    }
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     *
     * 根据价格列表和当前点券数，计算出能买到的最多英雄
     * @param costs int整型 一维数组 英雄点券价格列表
     * @param coins int整型  拥有的点券
     * @return int整型一维数组
     */
    public int[] solution(int[] costs, int coins) {
        int n = costs.length;
        // dp[i] : i元可以买到的最多英雄
        int[] dp = new int[coins + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < n; j++) {
                if (costs[j] <= i) {
                    dp[i] = Math.max(dp[i], dp[i - costs[j]] + 1);
                }
            }
        }
        List<Integer> heros = new ArrayList<>();
        int remainingCoins = coins;
        for (int i = dp[coins] - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (costs[j] <= remainingCoins && dp[remainingCoins - costs[j]] == i) {
                    heros.add(j);
                    remainingCoins -= costs[j];
                    break;
                }
            }
        }
        return null;
    }
}

