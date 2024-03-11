package com.xiaohe.前缀和.和为k的子数组;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 *
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 */
class Solution {
    /**
     * 解题思路:
     * 使用 HashMap 存储前缀和以及它们出现的次数
     * 在计算当前位置的前缀和 currentSum 时，查找一下 HashMap 中有没有值为 currentSum - k 的，
     * 如果有，说明找到了一个和为 'k' 的子数组，count++
     * 为什么先将 (0, 1) 放入 map 中？加入 arr = { 1, 2}, k = 3，判断 3 - 3 = 0，就得在 Map 中寻找0出现的个数
     * @param arr
     * @param k
     * @return
     */
    public int subarraySum(int[] arr, int k) {
        int count = 0;
        int sum = 0;
        // key : 前缀和
        // value : 该前缀和出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            // 计算当前位置的前缀和
            sum = sum + arr[i];
            // 看看 sum - k 有没有出现
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, -1, 0};
        int target = 0;
        System.out.println(new Solution().subarraySum(arr, target));
    }
}