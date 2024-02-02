package com.xiaohe.贪心.石子游戏;

import java.util.*;

class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        Deque<Integer> dq = new ArrayDeque<>();
        List<int[]> sums = new ArrayList<>();
        
        // 修正，用总和来计算而不是差值的绝对值
        for (int i = 0; i < n; i++) {
            sums.add(new int[]{i, aliceValues[i] + bobValues[i]});
        }
        
        // 修正，用总和的降序排列
        Collections.sort(sums, (a, b) -> b[1] - a[1]);
        
        for (int i = 0; i < n; i++) {
            dq.addLast(sums.get(i)[0]);
        }
        
        int res = 0;
        boolean aliceTurn = true;
        
        for (int i = 0; i < n; i++) {
            if (aliceTurn) {
                res += aliceValues[dq.pollFirst()]; // Alice 选择价值最大的石头
            } else {
                res -= bobValues[dq.pollFirst()]; // Bob 也选择价值最大的石头
            }
            aliceTurn = !aliceTurn; // 轮流选择
        }
        
        if (res > 0) {
            return 1;
        } else if (res < 0) {
            return -1;
        }
        return 0;
    }
}
