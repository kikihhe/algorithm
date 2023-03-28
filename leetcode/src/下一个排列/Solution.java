package 下一个排列;

import java.util.Arrays;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-03-28 21:46
 */
public class Solution {

    private void reverse(int[] nums, int begin, int end) {
        for (int j = begin, k = end; j <= k; j++, k--) {
            int temp = nums[j];
            nums[j] = nums[k];
            nums[k] = temp;
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void nextPermutation(int[] nums) {
        if(nums.length == 1) return;
        // 假如数组为:  1 2 3
        // 答案为: 1 3 2
        int i = nums.length - 1;
        while (i > 0 && nums[i-1] >= nums[i]) {
            i--;
        }
        // 找完一遍发现数组是递减的 3 2 1，那么将其倒序
        if (i <= 0) {
            reverse(nums, 0, nums.length - 1);
        } else {
            int t = nums.length - 1;
            while(nums[t] <= nums[i-1]) {
                t--;
            }
            swap(nums, t, i - 1);
            reverse(nums, i, nums.length-1);
        }

    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {1,1,5};
        s.nextPermutation(arr);

    }
}
