package 无重复字符的最长子串;

import java.util.HashMap;

class Solution {
    // 双重循环
//    public int lengthOfLongestSubstring(String s) {
//        if (s.length() == 0) return 0;
//        char[] arr = s.toCharArray();
//        int max = 1;
//        for (int i = 0; i < arr.length - 1; i++) {
//            int cur = 1;
//            StringBuilder str = new StringBuilder().append(arr[i]);
//            for (int j = i + 1; j < arr.length; j++) {
//
//                // 如果存在
//                if (str.toString().indexOf(arr[j]) >= 0) {
////                    max = Math.max(max, cur);
//                    break;
//                } else {
//                    str.append(arr[j]);
//                    cur ++;
//                }
//                    max = Math.max(max, cur);
//            }
//        }
//        return max;
//    }
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        int max = 0;
        int left = 0;

        char[] arr = s.toCharArray();
        // key: 字母
        // val: 字母对应的最新的下标
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            // 如果map中包含第i个字母，更新left的值
            if (map.containsKey(arr[i])) {
                int oldIndex = map.get(arr[i]);
                // 为什么要加一?
                // abcaefg    此时来到第二个a 的位置，判断有a, 且oldIndex=0,
                // 我们现在想要将窗口移动到没有重复字符的位置，不就是 oldIndex + 1 = 1吗？
                left = Math.max(oldIndex + 1, left);
            }
            map.put(arr[i], i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int pwwkew = s.lengthOfLongestSubstring(" ");
        System.out.println(pwwkew);
    }
}