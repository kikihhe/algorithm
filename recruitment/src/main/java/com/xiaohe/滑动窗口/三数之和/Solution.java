package com.xiaohe.滑动窗口.三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        int[] arr1 = new int[]{0, 0, 0};
        List<List<Integer>> lists = new Solution().threeSum(arr1);
        System.out.println(lists);
    }

    public List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        int i = 0;
        int j = 0;
        int k = 0;
        int n = arr.length;
        while (i <= arr.length - 3) {
            // 由于题意不要重复集合，所以 i、j、k都要判重
            // 不能使用 list.contains() 判断，因为要遍历，提交会超时
            if (i > 0 && arr[i] == arr[i - 1]) {
                i++;
                continue;
            }
            // 在 arr[i + 1] 和 arr[n - 1] 之间寻找和为 -arr[i] 的。
            j = i + 1;
            k = n - 1;
            int target = -arr[i];
            while (j < k) {
                int sum = arr[j] + arr[k];
                if (sum < target) {
                    j++;
                } else if (sum > target) {
                    k--;
                } else {
                    List<Integer> push = push(arr, i, j, k);
                    result.add(push);
                    j++;
                    while (j < k && arr[j] == arr[j - 1]) {
                        j++;
                    }
                    k--;
                    while (j < k && arr[k] == arr[k + 1]) {
                        k--;
                    }
                }
            }
            i++;

        }
        return result;
    }
    public List<Integer> push(int[] arr, int i, int j, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[i]);
        list.add(arr[j]);
        list.add(arr[k]);
        return list;
    }
}