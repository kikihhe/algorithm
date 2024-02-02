package com.xiaohe.贪心.最大数;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String a = o1 + o2;
                String b = o2 + o1;
                return b.compareTo(a);
            }
        });
        String join = String.join("", arr);
        // 如果是000，则返回false
        if (join.charAt(0) == '0') return "0";
        return join;
    }
}