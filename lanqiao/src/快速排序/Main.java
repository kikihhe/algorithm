package 快速排序;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 7, 100, 82, 7, 7, 12, 7, 11};
        new Main().quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        // 将数组分为三部分:
        // arr[i] < key, i ∈ [l, left]
        // arr[i] == key, i ∈ [left, right]
        // arr[i] > key, i ∈ [right, r]
        int key = getKey(arr, l, r);

        int left = l - 1;
        int right = r + 1;
        int i = l;

        // 升序
        while (i < right) {
            if (arr[i] < key) {
                swap(arr, ++left, i++);
            } else if (arr[i] == key) {
                i++;
            } else {
                swap(arr, --right, i);
            }
        }

        // 处理左右两边的
        quickSort(arr, l, left);
        quickSort(arr, right, r);
    }

    /**
     * 在数组的指定范围中选择基准点
     * @param arr
     * @param l
     * @param r
     * @return
     */
    public int getKey(int[] arr, int l, int r) {
        int random = new Random().nextInt(r - l + 1) + l;
        return arr[random];
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
