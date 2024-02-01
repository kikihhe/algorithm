package com.xiaohe.递归回溯剪枝.全排列Ⅱ;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个可包含重复数字的整数集合 nums ，按任意顺序 返回它所有不重复的全排列。
 *
 * 这道题的关键，也就是与全排列Ⅰ不同的是：同一次循环中，也就是在相同的位置，不能放相同的数。
 * 我让 check[arr[i]] 里面的 arr[i] + 10 的原因是题目给的数据为 [-10, 10] 所以要把负数也打到表上
 */
public class Solution {
    private List<List<Integer>> ret = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();
    private boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        process(nums);
        return ret;
    }
    public void process(int[] arr) {
        if (list.size() == arr.length) {
            ret.add(new ArrayList<Integer>(list));
            return;
        }
        // used数组代表相应下标的数据在全局是否已经使用过
        // check数组代表在这一次循环中，相同的数是否已经使用过
        boolean[] check = new boolean[20];
        for (int i = 0; i < arr.length; i++) {
            // 如果已经使用过，pass
            if (used[i] || check[arr[i] + 10]) {
                continue;
            }
            // 如果没有使用过
            used[i] = true;
            check[arr[i] + 10] = true;
            list.add(arr[i]);
            process(arr);
            list.remove(list.size() - 1);
            used[i] = false;
        }

    }
}