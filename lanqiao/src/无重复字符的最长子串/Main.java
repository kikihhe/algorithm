package 无重复字符的最长子串;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public int lengthOfLongestSubstring(String str) {
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        char[] arr = str.toCharArray();
        while (right < arr.length) {
            // 如果出现过，可能要更新left位置
            if (map.containsKey(arr[right])) {
                left = Math.max(left, map.get(arr[right] + 1));
            }
            // 此字符放入map
            map.put(arr[right], right);
            max = Math.max(max, right - left + 1);
            right++;
        }
        return 0;
    }
}
