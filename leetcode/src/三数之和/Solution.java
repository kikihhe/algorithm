package 三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) return res;
        Arrays.sort(nums);
        if (nums[0] > 0) return res;
        for (int i = 0; i < nums.length - 2; i++) {
            // 已经排序，nums[i]是从 nums[i]到nums[nums.length] 范围内最小的元素，如果连它都大于0，后面的也大于0，不用算了
            if (nums[i] > 0) break;

            // 当前数等于上一个数，上一个数的所有情况已总结,不用再算一遍
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // j在i后面一个, 是大于nums[i]的最小值
            // k在数组最后面，也就是数组最大值
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int s = nums[i] + nums[j] + nums[k];
                // 三数之和大于0，说明nums[k]太大了，把k减小。如果nums[k] == nums[k-1]，再把k减小1位
                if (s > 0) {
                    while(j < k && nums[k] == nums[--k]);
                }
                // 三数之和小于0，说明nums[j]太小了，把j增大。如果nums[j + 1] = nums[j]，再把j增大一位
                if (s < 0) {
                    while(j < k && nums[j] == nums[++j]);
                }
                // 三数之和等于0，说明满足要求。放入集合
                // 同时将j++, k--; 如果nums[++j] == nums[j] 或者nums[--k] == nums[k]，增大i或者减小k
                if (s == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while(j < k && nums[j] == nums[++j]);
                    while(j < k && nums[k] == nums[--k]);
                }
            }
        }



        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> lists = s.threeSum(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }

    }
}