package 反转字符串中的单词;

class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] str = s.split(" ");
        String result = "";
        for (int i = str.length - 1; i >= 0; i--) {
            if ("".equals(str[i])) continue;
            result += str[i] + " ";
        }
        result = result.trim();
        return result;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.reverseWords("a good   example");
        System.out.println(s);
    }
}