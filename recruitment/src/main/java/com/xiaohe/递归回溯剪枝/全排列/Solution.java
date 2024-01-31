package com.xiaohe.递归回溯剪枝.全排列;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<Integer>> ret = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();
    private boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        process(nums);
        return ret;
    }
    private void process(int[] arr) {
        // 如果List中的数量够了，添加到 ret 中
        if (list.size() == arr.length) {
            ret.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            // 如果用过了就跳过
            if (used[i]) {
                continue;
            }
            // 如果没有用过，可以使用
            used[i] = true;
            list.add(arr[i]);
            process(arr);
            // 用完了，重置标识
            used[i] = false;
            list.remove(list.size() - 1);
        }

    }
}