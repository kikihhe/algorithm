package 打家劫舍;


public class Solution {
    // 递归写法
    public static void diGui() {
        Solution solution = new Solution();

        int[] nums = new int[]{2,10,5};

        int result = solution.process(nums, 0);

        System.out.println(result);
    }

    public int process(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }
        return Math.max(process(nums, i + 2) + nums[i], process(nums, i + 1));
    }

    // 改dp
    public static void main(String[] args) {
        int[] nums = new int[]{2,10,5};
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        for (int i = 2; i < nums.length; i++) {

        }
    }

}