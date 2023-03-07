package 全排列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-03-03 13:00
 */
public class Solution {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> track = new ArrayList<>();

        back(nums, track);
        return list;

    }
    private void back(int[] nums, List<Integer> track) {
        if (track.size() == nums.length) {
            list.add(new ArrayList<Integer>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 如果已经包含这个数，跳过
            if (track.contains(nums[i])) {
                continue;
            }
            // 不包含这个数字，加进去
            track.add(nums[i]);
            back(nums, track);


        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> permute = s.permute(new int[]{1});
        System.out.println(permute);
    }
}
