package 跳跃游戏;

import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-03-29 22:21
 */
public class Solution {
        public boolean canJump(int[] nums) {
            if (nums.length == 1) {
                return true;
            }
            if(nums[0] == 0) return false;
            int[] dp = new int[nums.length];
            dp[0] = nums[0];

            for (int i = 1; i < dp.length - 1; i++) {
                dp[i] = Math.max(dp[i-1], nums[i] + i);
                if(dp[i] == i) return false;
            }
            return true;

        }

    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
        int[] arr = {2,0,0};
        Solution s = new Solution();
        boolean b = s.canJump(arr);
        System.out.println(b);
    }

}
