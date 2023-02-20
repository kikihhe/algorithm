package 最长回文子串的长度;

class Solution {
    public int longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int[][] dp = new int[arr.length][arr.length];
        // 将(0,0) (1,1) (2,2) (3,3) (4,4) (5,5)...初始化为1
        for (int i = 0; i < arr.length; i++) dp[i][i] = 1;

        // 开始填充dp[][]
        for (int i = arr.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < arr.length; j++) {
                dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                if (arr[i] == arr[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + 2);
                }
            }
        }
        return dp[0][arr.length - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "ab";
        int result = s.longestPalindrome(str);
        System.out.println(result);
    }
}