package 第一次只出现一次的字符;

class Solution {
    public char firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            // 往前面搜，indexof不等于自己就是有，continue;
            char c = s.charAt(i);
            if (s.indexOf(c) != i) {
                continue;
            }
            // 往后面搜，indexof(c, i+1)不等于-1就是有
            if (s.indexOf(c, i+1) != -1) continue;
            return c;
        }
        return ' ';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char c = solution.firstUniqChar("adbcbcdae");
        System.out.println(c);
    }
}