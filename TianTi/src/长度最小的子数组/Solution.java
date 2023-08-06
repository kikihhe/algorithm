package 长度最小的子数组;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        boolean flag = false;
        int left = 0;
        int right = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (left < nums.length) {
            while (right < nums.length) {
                // 如果此时 sum + nums[right] < target
                sum += nums[right];
                if (sum < target) {
                    right++;
                } else {
                    // 此时 sum + nums[right] >= target,缩小窗口 记录答案，将left+1
                    sum -= nums[left] + nums[right];
                    min = Math.min(min, right - left + 1);
                    left++;
                    flag = true;
                }
            }
            // right走到头, [left, right]的值之和也没有target大，可以直接break;
            break;
        }
        return flag ? min : 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] arr = {2, 3, 1, 2, 4, 3};
        int[] arr = {2,3,1,2,4,3};

        int target = 4;
        int result = solution.minSubArrayLen(target, arr);
        System.out.println(result);
    }
}