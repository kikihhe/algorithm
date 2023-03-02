package 搜索旋转数组;

class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return target == nums[0] ? 0 : -1;

        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) >> 1;
            if (nums[m] == target) return m;
            // 证明 0-m 这段数组是有序的
            if (nums[0] <= nums[m]) {
                if (nums[0] <= target && nums[m] >= target) {
                    j = m - 1;
                } else {
                    i = m + 1;
                }
            } else {
                // 说明 0-m 不是有序的, 即从m-j是有序的
                if(nums[m] <= target && nums[nums.length-1] >= target) {
                    i = m + 1;
                } else {
                    j = m - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1};
        Solution solution = new Solution();
        int search = solution.search(arr, 1);
        System.out.println(search);
    }
}