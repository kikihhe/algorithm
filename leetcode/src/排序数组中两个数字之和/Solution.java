package 排序数组中两个数字之和;

import java.util.Arrays;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-04-02 18:03
 */
public class Solution {
    // 二分查找, 找到返回下标
    public int find(int[] arr, int target, int left, int right) {

        while(left <= right) {
            int mid = (left+right) >> 1;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                // 1 2 3 4 5
                left = mid+1;

            } else {
                right = mid-1;
            }
        }
        return -1;

    }
    public int[] twoSum(int[] arr, int target) {
        int[] result = new int[2];
        for (int i = 0; i < arr.length; i++) {
            int index = find(arr, target-arr[i], i+1, arr.length-1);
            if(index != -1) {
                result[0] = i;
                result[1] = index;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2,3,4};
        int target = 6;
        int[] ints = solution.twoSum(arr, target);
        System.out.println(Arrays.toString(ints));
    }
}
