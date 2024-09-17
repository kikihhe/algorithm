package com.xiaohe.排序.稳定排序.归并排序;

public class Solution {
    /**
     * 归并排序
     * @param arr
     * @param left
     * @param right
     * @param temp 辅助数组
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid, temp);
        mergeSort(arr, mid + 1, right, temp);
        // 合并两个有序区间, 先把数据从arr移动到temp
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            // 左边的数组遍历完成
            if (i == mid + 1) {
                arr[k] = temp[j++];
            } else if (j == right + 1) {
                // 右边的数组遍历完成
                arr[k] = temp[i++];
            } else if (temp[i] <= temp[j]) {
                arr[k] = temp[i++];
            } else {
                arr[k] = temp[j++];
            }
        }
    }
}
