package 数组中重复的数字;

class Solution {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; ) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i]) {
                return nums[i];
            }

            // 交换i和nums[i]位置的值
            int temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;

        }
        return -1;

    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 1, 1, 0};
        Solution solution = new Solution();
        System.out.println(solution.findRepeatNumber(arr));
    }
}