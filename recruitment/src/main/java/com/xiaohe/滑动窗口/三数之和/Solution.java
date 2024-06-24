package com.xiaohe.滑动窗口.三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，使得 a + b + c = 0 ？请找出所有和为 0 且 不重复 的三元组。
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 *
 * 示例 2：
 * 输入：nums = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[]
 *
 * 题解：
 * 使用三个指针 i 、 j 、k
 * i 会遍历数组中的每一个位置（ 0 ~ n-3 , 因为有三个指针）。当 i 遍历到一个位置时，在后面的数组中寻找和为 -arr[i] 的，也就是使用双指针从两边向中间找。
 * 注意 ：要去除数据重复的情况，如 1 1 1 2 3 3 5 ，第一个1和第二个1计算得到的结果一样，所以没必要重复计算。i、j、k 都需要跳过重复数据
 */
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