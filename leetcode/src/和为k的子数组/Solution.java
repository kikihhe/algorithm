package 和为k的子数组;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int[][] dp = new int[nums.length + 1][nums.length + 1];
        int count = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i][i] = nums[i - 1];
        }
        for (int i = 1; i < dp.length - 1; i++) {
            for (int j = i + 1; j < dp[i].length; j++) {
                dp[i][j] = dp[i][j-1] + nums[j - 1];

            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = i; j < dp[i].length; j++) {
                if (dp[i][j] == k) count++;
            }
        }

        return count;


    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1,1,1};
        int k = 2;

        int count = solution.subarraySum(arr, k);
        System.out.println(count);

    }
}