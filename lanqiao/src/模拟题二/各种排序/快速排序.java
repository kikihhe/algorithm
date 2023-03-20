package 模拟题二.各种排序;


import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序不稳定
 */
public class 快速排序 {
    public static void quickSort(int arr[], int left, int right) {
        if (left >= right) {
            return ;
        }
        int key = partition(arr, left, right);
        // 对左边进行排序
        quickSort(arr, left, key-1);
        // 对右边进行排序
        quickSort(arr, key+1, right);

    }

    private static int partition(int[] arr, int left, int right) {
        while (left < right) {
            while (left <right && arr[left] <= arr[right]) {
                left++;
            }
            if (left < right) swap(arr, left, right);

            while (left < right && arr[right] >= arr[left]) {
                right--;
            }
            if (left < right) swap(arr, left, right);
        }
        // left和right相遇的位置就是key应该在的位置，将key与left的值交换
        return left;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = new int[100];
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            arr[i] = random.nextInt(10000);
        }
        quickSort(arr, 0, arr.length-1);


        System.out.println(Arrays.toString(arr));


    }
}
