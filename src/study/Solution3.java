package study;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-10-14 22:51
 */
public class Solution3 {

    public int maxAscendingSum(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int pre = nums[0];
        int sum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > pre) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            max = Math.max(sum, max);
            pre = nums[i];
        }
        return max;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(arr, target)));

    }
    public static int[] twoSum(int[] nums, int target) {
        // Map<value, index>
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i,map.get(target - nums[i])};
            }
        }
        return null;

    }

}
