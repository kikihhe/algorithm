package com.xiaohe.排序.稳定排序;

/**
 * @author : 小何
 * @Description :
 * @date : 2024-03-10 12:31
 */
public class 归并排序 {
    public static void main(String[] args) {

    }

    /**
     * 归并排序
     * @param arr 待排序数组
     * @return 已排序数组
     */
    public static int[] sort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        return arr;
    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        // 数组中只有一个元素时结束
        if (left == right) {
            return;
        }
        int mid = (left + right) / 2;
        // 排序左边
        mergeSort(arr, left, mid, temp);
        // 排序右边
        mergeSort(arr, mid + 1, right, temp);

        // 合并两个区间, 先将数据从 arr 转移到 temp
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }
        int i = left;
        int j = mid + 1;
        // k 操作原始数组 arr
        // i 操作 temp 左边，[left, mid]
        // j 操纵 temp 右边，[mid + 1, right]
        for (int k = left; k <= right; k++) {
            // 如果 i 移到头了，只移动 j
            if (i == mid + 1) {
                arr[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                // 如果 j 移动到头了，只移动 i
                arr[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                // 保证稳定性 : 左边的移动到左边
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
        }
    }
}
