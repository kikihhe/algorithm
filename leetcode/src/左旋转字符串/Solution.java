package 左旋转字符串;

class Solution {
    public String reverseLeftWords(String s, int n) {
         String str = s.substring(0,n);
        String str1 = s.substring(n, s.length());
        return str1 + str;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.reverseLeftWords("abcdefg", 2);
        System.out.println(s);
    }
}