package 打家劫舍Ⅱ;

class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // 至少有三间屋子
        return Math.max(range(nums, 0, length - 2), range(nums, 1, length - 1));


    }
    private int range(int[] arr, int begin, int end) {
        int first = arr[begin];
        int second = Math.max(arr[begin], arr[begin + 1]);

        for (int i = begin + 2; i <= end; i++) {
            int temp = second;
            second = Math.max(first + arr[i], second);
            first = temp;
        }
        return second;

    }
}