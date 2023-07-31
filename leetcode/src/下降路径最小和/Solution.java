package 下降路径最小和;

class Solution {
    private int min(int a, int b, int c) {
        int minValue = Math.min(a, b);
        minValue = Math.min(minValue, c);
        return minValue;

    }

    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < m; i++) {
            // i是横排
            for (int j = 0; j < n; j++) {
                int a = j == 0 ? Integer.MAX_VALUE : dp[i - 1][j - 1];
                int b = dp[i - 1][j];
                int c = j == n - 1 ? Integer.MAX_VALUE : dp[i - 1][j + 1];
                dp[i][j] = min(a, b, c) + matrix[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[m - 1][i]);
        }
        return min;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = new int[][]{
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };
        int min = solution.minFallingPathSum(matrix);
        System.out.println(min);
    }
}