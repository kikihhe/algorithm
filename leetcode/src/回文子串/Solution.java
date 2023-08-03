package 回文子串;

class Solution {
    public int countSubstrings(String s) {
        if (s.length() == 1) return 1;

        char[] arr = s.toCharArray();
        int n = arr.length;
        boolean[][] dp = new boolean[n][n];
        int count = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = true;

            }
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                dp[i][j] = (arr[i] == arr[j]) && dp[i + 1][j - 1];
                if (dp[i][j]) {
                    count++;
                }

            }
        }


        return count;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int count = solution.countSubstrings("ab");
        System.out.println(count);
    }
}