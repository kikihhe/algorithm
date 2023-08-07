package 最长递增子序列;

class Solution {
    public int lengthOfLIS(int[] arr) {
        int max = 0;
        int[] dp = new int[arr.length];
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }

        return max + 1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLIS(arr));
    }
}