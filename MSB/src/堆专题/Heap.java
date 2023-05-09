package 堆专题;


/**
 * @author : 小何
 * @Description : 堆排序，时间复杂度: n * log(n)
 * @date : 2023-05-09 21:01
 */
public class Heap {
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
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
            swap(arr, i, 0);

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
            swap(arr, maxIndex, i);
            heap(arr, n, maxIndex);
        }


    }

}
