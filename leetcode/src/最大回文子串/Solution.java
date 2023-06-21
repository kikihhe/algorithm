package 最大回文子串;

class Solution {
       public String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) return s;
        char[] arr = s.toCharArray();
        int max = -1;
        int begin = 0;
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
// 确定长度范围
        for (int L = 2; L <= length; L++) {
            for (int i = 0; i < length; i++) {
                int j = L + i - 1;
                if (j >= length) {
                    break;
                }
                
                if (arr[i] != arr[j]) {
                    dp[i][j] = false;
                } else  {
                    if (j - i < 3) dp[i][j] = true;
                    else dp[i][j] = dp[i+1][j-1];    
                }

                if (dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + max);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "abccbacd";
        String s = solution.longestPalindrome(str);
        System.out.println(s);
    }
}