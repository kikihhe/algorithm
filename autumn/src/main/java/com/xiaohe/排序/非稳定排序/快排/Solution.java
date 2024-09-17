package com.xiaohe.排序.非稳定排序.快排;

import java.util.Random;

public class Solution {
    public static void main(String[] args) {

    }

    public void quickSort(int[] arr, int l, int r) {
        if (l >= r) return;
        int key = getKey(arr, l, r);
        // 根据 key 把数组分成三部分
        // [l, left] : < key
        // (left, right) : == key
        // [right, r] : > key
        int left = l - 1;
        int right = r + 1;
        int i = l;
        while (i < right) {
            if (arr[i] < key) {
                swap(arr, ++left, i++);
            } else if (arr[i] == key) {
                i++;
            } else {
                swap(arr, --right, i);
            }
        }
        // 排序左边
        quickSort(arr, l, left);
        // 排序右边
        quickSort(arr, right, r);
    }

    /**
     * 在数组的指定区间随机选择一个数
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private int getKey(int[] arr, int l, int r) {
        int index = new Random().nextInt(r - l + 1) + l;
        return arr[index];
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
