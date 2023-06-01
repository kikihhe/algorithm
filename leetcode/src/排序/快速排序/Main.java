package 排序.快速排序;

import 排序.Util;

import java.util.Arrays;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-04-12 12:33
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 8, 5, 6, 3, 10, 2};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        // 获取中间位置，中间排序好之后排序它的左边和右边
        int mid = partition(arr, low, high);

        quickSort(arr, low, mid - 1);
        quickSort(arr, mid + 1, high);
    }

    /**
     * 以arr[high]为基准，将小于它的数放到它左边，将大于它的数放到右边，最后返回它应该在的下标
     */
    private static int partition(int[] arr, int low, int high) {
        int i = low;
        int p = arr[high];

        for (int j = low; j < high; j++) {
            if (arr[j] < p) {
                // 交换arr[i]与arr[j]
                Util.swap(arr, i, j);
                i++;
            }
        }
        Util.swap(arr, i, high);
        return i;
    }
}
