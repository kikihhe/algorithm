package com.xiaohe.递归回溯.最大数;

/**
 * 给你一个数 n, 和一个数组 arr, 请你找出用 arr 中数字拼接的小于 n 的最大数
 * 输入 :
 *      n : 23121
 *      arr : [2, 4, 9]
 * 输出 :
 *      22999
 */
public class Solution {

    static int value = 14132;
    static String str = String.valueOf(value);
    static int[] arr = {1, 4, 9};

    static boolean DFS(int index, boolean flag, int sum, int[] arr) {

        if (index == str.length()) {
            System.out.println(sum);
            return true;
        }
        if (flag) {
            return DFS(index + 1, true, sum * 10 + arr[arr.length - 1], arr);
        } else {
            int tmp = str.charAt(index) - '0';
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] == tmp) {
                    if (DFS(index + 1, false, sum * 10 + arr[i], arr)) {
                        return true;
                    }
                } else if (arr[i] < tmp) {
                    if (DFS(index + 1, true, sum * 10 + arr[i], arr)) {
                        return true;
                    }
                }
            }
        }
        // 上面代码没有return，说明数组中最小的元素都大于数字该位的值
        // 如果当前位置在第一个，例如 n=123, arr=[4, 5, 6], 那么第一位不用选，我们想要的答案是 66，所以可以继续向下遍历
        // 如果当前位置不在第一个，例如 n = 412, arr:[3, 7, 8], 我们想要的答案就是378，直接返回即可。
        // 回溯一步（退回一步）
        if (index == 0) {
            return DFS(index + 1, true, sum, arr);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        DFS(0, false, 0, arr);
    }

}
