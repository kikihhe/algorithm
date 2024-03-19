package com.xiaohe.排序.非稳定排序;

import com.xiaohe.动态规划.编辑距离.Solution;

import java.util.Arrays;
import java.util.Random;

/**
 * @author : 小何
 * @Description :
 * @date : 2024-03-10 12:32
 */
public class 快速排序 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 7, 100, 82, 7, 7, 12, 7, 11};
        new 快速排序().quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    public void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int key = getKey(arr, l, r);
        int left = l - 1;
        int right = r + 1;
        int i = l;
        // 将数组分为三部分 :
        // [l, left], [left + 1, right - 1], [right, r]
        while (i < right) {
            if (arr[i] < key) {
                swap(arr, ++left, i++);
            } else if (arr[i] == key) {
                i++;
            } else {
                swap(arr, --right, i);
            }
        }
        // 排序 key 的左边和右边
        quickSort(arr, l, left);
        quickSort(arr, right, r);

    }
    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * 选择 [l ,r] 范围内的基准点
     */
    public int getKey(int[] arr, int l, int r) {
        int random = new Random().nextInt(r - l + 1) + l;
        return arr[random];
    }
}
