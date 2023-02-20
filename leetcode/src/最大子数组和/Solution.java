package 最大子数组和;


// 解题思路: 使用动态规划，计算每一个以i结尾的连续子数组的最大和。
// 如何计算？要么是他自己，要么是上一个数加上他自己。 二者的最大值
// dp[i] = Math.max(nums[i-1], dp[i-1]+nums[i-1])
class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length + 1];

        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(nums[i-1], dp[i-1]+nums[i-1]);
        }

        int max = dp[1];
        for (int i = 1; i < dp.length; i++)
            max = Math.max(max, dp[i]);

        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{1};

        int result = s.maxSubArray(arr);
        System.out.println(result);
    }
}