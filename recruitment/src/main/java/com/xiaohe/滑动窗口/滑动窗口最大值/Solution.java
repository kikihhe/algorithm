package com.xiaohe.滑动窗口.滑动窗口最大值;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回 滑动窗口中的最大值 。
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                   最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] x = new Solution().maxSlidingWindow(arr, k);
        System.out.println(Arrays.toString(x));
    }

    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        int length = n - k + 1;
        int[] result = new int[length];
        int resultIndex = 0;
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            // 入窗口, 新元素比队列右边大时，将队列右边删除
            while (!queue.isEmpty() && arr[queue.peekLast()] <= arr[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
            // 出窗口, 最左边和最右边的下标之差要为k
            if (queue.peekFirst() == i - k) {
                queue.pollFirst();
            }
            // 找出答案
            if (i >= k - 1) {
                result[resultIndex++] = arr[queue.peekFirst()];
            }
        }
        return result;
    }
}