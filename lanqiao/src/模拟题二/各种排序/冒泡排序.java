package 模拟题二.各种排序;

import java.util.Arrays;
import java.util.Random;

/**
 * 冒泡排序是稳定排序
 */
public class 冒泡排序 {
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length == 1)
            return;

        for (int i = 0; i < arr.length; i++) {
            int flag = 0;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    flag = 1;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if (flag == 0) break;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[100];
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            arr[i] = random.nextInt(1000);
        }
        bubbleSort(arr);

        System.out.println(Arrays.toString(arr));

    }
}
