package 零钱兑换;

class Solution {


    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (coins.length == 1 && amount % coins[0] != 0) return -1;
        process(coins, amount, 0);
        return result;
    }

    private int result = Integer.MAX_VALUE;

    private void process(int[] arr, int amount, int count) {
        if (amount < 0) return;
        if (amount == 0) {
            result = Math.min(result, count);
            return;
        }
        // 否则，从开始找
        for (int i = 0; i < arr.length; i++) {
            process(arr, amount - arr[i], count + 1);
        }

    }


    public static void main(String[] args) {
        Solution solution = new Solution();
1        int[] arr = {1, 2, 5};
        int target = 10;

        int count = solution.coinChange(arr, target);
        System.out.println(count);
    }
}