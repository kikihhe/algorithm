package 反转单词顺序;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public String reverseWords(String s) {
        s.trim();
        List<String> list = Arrays.asList(s.split("\\s+"));
        Collections.reverse(list);
        String join = String.join(" ", list);
        return join;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.reverseWords("the sky is blue");
        System.out.println(s);
    }
}