package 爬楼梯;

class Solution {
    public int climbStairs(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
 
        for (int i = 2; i <= n; i++) {
            arr[n] = arr[n-1] + arr[n-2];
        }
        return arr[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.climbStairs(3);
    }

}