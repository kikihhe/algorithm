package com.xiaohe.排序.找出第K大的数;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class Main {
    /**
     * 有多种解决方法 : 选择排序、插入排序、快速排序...
     */
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(select(arr, 2));
    }

    // 选择排序找出数组中第k大的数
    public static int select(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            int max = arr[i];
            int maxIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                    maxIndex = j;
                }
            }
            if (i != maxIndex) {
                swap(arr, i, maxIndex);
            }
            // 此次寻找结束，判断i是否为k
            if (i + 1 == k) {
                return arr[i];
            }
        }
        return -1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
