package com.xiaohe.贪心.和为K的最少斐波那契数目;


import java.util.ArrayList;
import java.util.List;

/**
 * 给你数字 k ，请你返回和为 k 的斐波那契数字的最少数目，其中，每个斐波那契数字都可以被使用多次。
 *
 * 输入：k = 7
 * 输出：2
 * 解释：斐波那契数字为：1，1，2，3，5，8，13，……
 * 对于 k = 7 ，我们可以得到 2 + 5 = 7 。
 *
 * 输入：k = 10
 * 输出：2
 * 解释：对于 k = 10 ，我们可以得到 2 + 8 = 10 。
 */
class Solution {
    private List<Integer> list = new ArrayList<>();
    public int findMinFibonacciNumbers(int k) {
        getFibonacciLetterK(k);
        int count = 0;
        for (int i = list.size() - 1; i >= 0 && k > 0; i--) {
            int num = list.get(i);
            if (k >= num) {
                k -= num;
                count++;
            }
        }
        return count;
    }

    /**
     * 获取小于等于k的所有斐波那契数列
     * @param k
     */
    public void getFibonacciLetterK(int k) {
        list.add(1);
        int a = 0;
        int b = 1;
        while (a + b <= k) {
            int c = a + b;
            list.add(c);
            a = b;
            b = c;
        }
    }
}