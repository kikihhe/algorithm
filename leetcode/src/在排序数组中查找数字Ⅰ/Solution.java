package 在排序数组中查找数字Ⅰ;

class Solution {
    public int find(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left+right) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) left = mid + 1;
            if (nums[mid] > target) right = mid - 1;
        }
        return -1;
    }
    public int getCount(int[] arr, int index, int target) {
        int count = 1;
        
        int i = index - 1;
        int j = index + 1;
        while(i >= 0 && arr[i--] == target) {
            count++;
        }
        while (j < arr.length && arr[j++] == target) {
            count++;
        }
        return count;
    }
    public int search(int[] nums, int target) {
        // 二分法找到数字下标
        int index = find(nums, target);
        if (index == -1) return 0;
        return getCount(nums, index, target);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = new int[]{5,7,7,7,7,7,7,8,8,10};
        System.out.println(solution.search(arr, 10));
    }
}