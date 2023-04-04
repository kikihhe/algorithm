package 排序.堆排序;

import 排序.Util;

import java.util.Arrays;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-04-02 14:36
 */
public class Main {
    // 大根堆，将i挂到合适的位置
    // n: 数组长度
    // i: 当前需要维护的下标
    public static void heap(int[] arr, int n, int i) {
        // 自己、左孩子、右孩子哪一个更大
        int larger = i;
        // 左孩子、右孩子
        int left = i*2 + 1;
        int right = i*2 + 2;

        // 找出当前节点应该往哪里挂
        if (left < n && arr[left] > arr[larger]) {
            larger = left;
        }
        if (right < n && arr[right] > arr[larger]) {
            larger = right;
        }
        // 最大值不是他，说明i有一个孩子比它大，让i向下走
        if (larger != i) {
            Util.swap(arr, i, larger);
            heap(arr, arr.length, larger);
        }
    }

    public static void heapSort(int[] arr) {
        // 建堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heap(arr, arr.length, i);
        }
        // 排序
        for (int i = arr.length - 1; i > 0; i--) {
            Util.swap(arr, 0, i);
            heap(arr, i, 0);
        }
    }


    public static void main(String[] args) {
        int[] arr = {2,3,1,4,7,9,8,14,10,16};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
