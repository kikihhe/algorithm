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

    /**
     * 使用双端队列维护窗口中的最大值，注意队列并不是窗口
     * 我们让双端队列中存储递减的数据的下标，那么每次获取就是窗口中的最大数据
     *  [ 4, 3, 7, 2] 1
     * 这个窗口内的最大数据为7，已经确认哪怕窗口向右移动也不会有 4 和 3 的事了
     *
     * 所以得出结论:
     * 如果新数据入窗口，可以将小于新数据的队列尾部数据移除，一直到尾部数据比新数据大，然后再将新数据放在尾部
     *
     * 出窗口: 当前队列头部存着当前窗口内的最大值，队列头部数据的下标 = i - k，那么就该出窗口
     *
     * 取数据: 每移动一次都要取窗口内的最大数据(队列的头部)，不过有个前提，一开始窗口还没这么大的时候不要取
     * @param arr
     * @param k
     * @return
     */
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