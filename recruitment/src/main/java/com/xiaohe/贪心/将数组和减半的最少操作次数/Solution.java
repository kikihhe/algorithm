package com.xiaohe.贪心.将数组和减半的最少操作次数;

import java.util.PriorityQueue;

class Solution {
    public int halveArray(int[] arr) {
        double sum = 0;
        // 创建大根堆，将元素全部装进去
        PriorityQueue<Double> queue = new PriorityQueue<>((a,b) -> b.compareTo(a));
        for (int i : arr) {
            sum += i;
            queue.offer(i * 1.0);
        }
        int count = 0;
        sum = sum / 2.0;
        while (sum > 0) {
            // 从大根堆中取出当前的最大值，除以二就是可以减去的最大值
            double max = queue.poll() / 2;
            sum -= max;
            queue.offer(max);
            count++;
        }
        return count;
    }
}