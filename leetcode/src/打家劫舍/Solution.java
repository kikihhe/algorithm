package 打家劫舍;


public class Solution {
    public int rob(int[] nums) {
        //
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        for (int i = 2; i < dp.length; i++) {
            // 偷这间房，说明dp[i] = dp[i-2] + nums[i-1];
            // 不偷这间房，说明 dp[i] = dp[i-1]
            // 偷与不偷取最大值
            dp[i] = Math.max(dp[i-2] + nums[i-1], dp[i] = dp[i-1]);
        }
        return dp[nums.length];

    }




    // 改dp
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = new int[]{2,7,9,3,1};
        int rob = solution.rob(ints);
        System.out.println(rob);

    }

}