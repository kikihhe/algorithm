package 排序.堆排序;

import 排序.Util;

import java.util.Arrays;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-04-02 14:36
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 6, 2, 8, 4, 3, 10};
        heapSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 堆排序
     * @param arr
     * @param n 数组长度
     */
    public static void heapSort(int[] arr, int n) {
        // 构建堆(大)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heap(arr, n, i);
        }
        // 开始排序
        for (int i = n - 1; i > 0; i--) {
            Util.swap(arr, i, 0);
            heap(arr, i, 0);
        }
    }

    /**
     * 调整堆
     * @param arr 需要调整的数组
     * @param n 数组大小
     * @param i 当前调整的下标
     */
    public static void heap(int[] arr, int n, int i) {
        // 如果没有孩子，直接结束
        if (i * 2 + 1 > n) return;
        int maxIndex = i;

        int leftChild = i * 2 + 1;
        int rightChild = i * 2 + 2;

        if(leftChild < n && arr[maxIndex] < arr[leftChild]) {
            maxIndex = leftChild;
        }
        if(rightChild < n && arr[maxIndex] < arr[rightChild]) {
            maxIndex = rightChild;
        }
        // 如果有孩子比自己大，交换自己与孩子的位置，再去调整自己的位置
        if (maxIndex != i) {
            Util.swap(arr, maxIndex, i);
            heap(arr, n, maxIndex);
        }


    }

}
