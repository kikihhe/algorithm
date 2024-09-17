package com;

public class Main3 {
    public static void main(String[] args) {
        int[] nums = new int[] {1,17,5,10,13,15,10,5,16,8};
        Main3 main3 = new Main3();
        main3.wiggleMaxLength(nums);
        System.out.println(main3.max);
    }
    /**
     *
     * 1. 求出差值
     * 2. 计算出最长的正负交替的数量
     * @param nums int整型 一维数组 摆动序列
     * @return int整型
     */
    public int wiggleMaxLength(int[] nums) {
        // 1. 求出差值
        int[] arr = new int[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            arr[i-1] = nums[i] - nums[i-1];
        }
        boolean a = nums[0] > 0;
        process(arr, 1, a, 2);
        if (max >= nums.length) {
            max = nums.length;
        }
        return max;
    }

    private int max = 2;
    /**
     *
     * @param arr
     * @param index 此时的下标
     * @param flag
     */
    private void process(int[] arr, int index, boolean flag, int length) {
        if (index >= arr.length) {
            max = Math.max(max, length);
            return;
        }
        boolean a = arr[index] > 0;
        if (!(a & flag)) {
            length++;
            max = Math.max(max, length);
        }
        for (int i = index + 1; i < arr.length; i++) {
            process(arr, i, a, length);
        }
    }
}
