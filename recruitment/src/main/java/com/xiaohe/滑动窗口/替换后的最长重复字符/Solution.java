package com.xiaohe.滑动窗口.替换后的最长重复字符;

class Solution {
    public int characterReplacement(String s, int k) {
        // 滑动窗口中每一个字符出现的次数
        // map[0] : 当前窗口中 A 出现的次数
        int[] map = new int[30];
        char[] arr = s.toCharArray();
        // 当前字符出现了几次
        int maxN = 0;
        int left = 0;
        int right = 0;
        int ret = 0;
        while (right < arr.length) {
            // 1. 进窗口
            map[arr[right] - 'A']++;
            // 1.1 进窗口的这个字符出现的最大次数
            maxN = Math.max(maxN, map[arr[right] - 'A']);
            // 1.2 如果窗口大小 (right - left + 1) > maxN + k, 说明补不全
            if (right - left + 1> maxN + k) {
                 // 2. 出窗口
                 map[arr[left] - 'A']--;
                 left++;
            }
            right++;
            ret = Math.max(ret, right - left);
        }
        return ret;

    }
}