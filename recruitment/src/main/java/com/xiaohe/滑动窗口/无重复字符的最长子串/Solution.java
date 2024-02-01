package com.xiaohe.滑动窗口.无重复字符的最长子串;

import java.util.HashMap;

/**
 * deabcadca
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        char[] arr = s.toCharArray();
        int max = 0;
        while (right < arr.length) {
            // 如果包含，可能要更新 left 的位置，什么叫做可能?
            if (map.containsKey(arr[right])) {
                // deabcadca 中，第一次出现包含的情况是下标为 5 的 a ，第二次是下标为 6 的d
                // 第一次 : 此时 right = 5, left = 0, 出现的数据为 a, 它上次在 2 出现过
                //         将 left 更新为 此数据之前的位置+1，也就是 left = map.get(arr[right]) + 1 = 3
                // 第二次 : 此时 right = 6, left = 3, 出现的数据为 d, 它上次在 0 出现过
                //         难道还要 left = 0 + 1 = 1 吗 ？ left 不需要更新了, left = left
                left = Math.max(left, map.get(arr[right]) + 1);
            }
            map.put(arr[right], right);
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring(" "));
    }
}