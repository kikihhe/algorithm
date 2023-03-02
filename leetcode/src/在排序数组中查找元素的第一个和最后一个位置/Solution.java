package 在排序数组中查找元素的第一个和最后一个位置;

import java.util.Arrays;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-03-02 16:17
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int index = -1;
        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            int mid = (i + j) >> 1;
            if (nums[mid] == target) {
                index = mid;
                break;
            }
            if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        if (index != -1) {
            int begin = index;
            int end = index;
            while (begin >= 0 && nums[begin] == target) {
                begin -- ;
            }
            while (end <= nums.length - 1 && nums[end] == target) {
                end ++ ;
            }
            return new int[]{begin+1, end - 1};
        } else {
            return new int[]{-1, -1};
        }


    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = solution.searchRange(new int[]{1}, 1);
        System.out.println(Arrays.toString(ints));
    }
}
