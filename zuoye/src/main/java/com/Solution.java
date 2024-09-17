package com;


/**
 * [ 1 , 0 , 1 , 2 , 1 , 1 , 7 , 5 ],
 * [ 0 , 1 , 0 , 1 , 0 , 1 , 0 , 1 ],
 * 3
 *
 * 输出 16
 */
public class Solution {
    public static void main(String[] args) {
        int[] a = { 1 , 0 , 1 , 2 , 1 , 1 , 7 , 5 };
        int[] b = { 0 , 1 , 0 , 1 , 0 , 1 , 0 , 1 };
        int x = 3;
        System.out.println(new Solution().maxSatisfiedSolution(a, b, x));
    }

    int max = -1;
    public int maxSatisfiedSolution (int[] a, int[] b, int x) {
        int now = 0;
        for (int i = 0; i < a.length; i++) {
            if (b[i] == 0) {
                now += a[i];
            } else {
                // 假设今天雄起了
                maxS(a, b, i, x, now);
            }
        }
        max = Math.max(max, now);
        return max;
    }
    // index : 当前下标
    // x : 最多可以雄起几天
    // now : 当前服务的客人
    private void maxS(int[] a, int[] b, int index, int x, int now) {
        System.out.println("下标 " + index + " 开始雄起");
        // 今天雄起了，雄起三天
        int end = index + x;
        for (int i = index; i < a.length; i++) {
            if (i < end) {
                now += a[i];
            } else {
                if (b[i] == 0) {
                    now += a[i];
                }
            }
        }
        System.out.println("下标 " + index + " 开始雄起时，最终结果: " + now);
        max = Math.max(now, max);
    }
}