package study;


import java.util.HashMap;
import java.util.Map;


public class Solution1 {
    private static Map<String, Integer> map = new HashMap<>();
    private static final long MOD = (long) 1e9 + 7;
    public static int distinctSubseqII(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i ++) {
            for (int j = 1; j <= arr.length - i; j ++) {
                String str = new String(arr, i, j);
                if (!map.containsKey(str)) {
                    map.put(str,1);
                }
            }
        }
        System.out.println(map);
        return map.size();
    }

    public static void main(String[] args) {
        int count = distinctSubseqII("abc");
        System.out.println(count);
    }
}