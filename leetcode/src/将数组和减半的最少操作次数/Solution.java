package 将数组和减半的最少操作次数;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int halveArray(int[] nums) {
        double sum = 0;
        int count = 0;
        // 大根堆
        PriorityQueue<Double> queue = new PriorityQueue<>((a, b) -> b.compareTo(a));
        for (int i : nums) {
            sum += i;
            queue.offer(i * 1.0);
        }
        sum /= 2.0;
        while (sum > 0) {
            Double max = queue.poll() / 2;
            sum -= max;
            queue.offer(max);
            count++;
        }
        return count;

    }

    public static void main(String[] args) {
        int count = new Solution().halveArray(new int[]{18, 22, 62, 61, 1, 88, 17, 98, 38, 32, 51, 57, 7, 29, 40, 61, 62, 13, 89, 41, 73, 85, 88, 60, 59, 76, 71, 76, 76, 41, 29, 43, 19, 9, 79});
        System.out.println(count);
    }


}