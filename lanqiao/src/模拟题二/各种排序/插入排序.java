package 模拟题二.各种排序;

import java.util.Arrays;
import java.util.Random;

/**
 * 插入排序是稳定的
 */
public class 插入排序 {

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            int j = i-1;
            while (j >= 0 && arr[j] > arr[j+1]) {
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
                j--;
            }
        }

    }
    public static void main(String[] args) {
        int[] arr = new int[100];
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            arr[i] = random.nextInt(10000);
        }
        insertSort(arr);

        System.out.println(Arrays.toString(arr));

    }
}
