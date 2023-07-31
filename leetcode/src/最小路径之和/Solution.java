package 最小路径之和;

class Solution {
    public int minPathSum(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = arr[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + arr[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + arr[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + arr[i][j];
            }
        }
        return dp[m - 1][n - 1];

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
//                {4, 2, 1}
        };
        int min = solution.minPathSum(arr);

        System.out.println(min);
    }
}