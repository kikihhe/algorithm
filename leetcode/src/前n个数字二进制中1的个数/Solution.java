package 前n个数字二进制中1的个数;

import java.util.Arrays;

class Solution {
    public int[] countBits(int n) {
        if (n == 0) {
            return new int[]{0};
        }
        if (n == 1) {
            return new int[] {0,1};
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 偶数
            if (i % 2 == 0) {
                dp[i] = dp[i>>1] ;

            } else {
                dp[i] = dp[i-1] + 1;
            }
        }
        return dp;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] ints = s.countBits(2);
        System.out.println(Arrays.toString(ints));
    }
}