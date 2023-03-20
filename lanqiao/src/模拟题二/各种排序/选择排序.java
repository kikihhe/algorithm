package 模拟题二.各种排序;

import java.util.Arrays;
import java.util.Random;

/**
 * 选择排序是不稳定排序
 */
public class 选择排序 {
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length == 1) {
            return ;
        }
        for (int i = 0; i < arr.length; ) {
            int max = arr[i];
            int maxIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                    maxIndex = j;
                }
            }
            // 交换
            if (maxIndex!=i) {
                int temp = arr[i];
                arr[i] = arr[maxIndex];
                arr[maxIndex] = arr[i];
            }
            i++;

        }
    }
    public static void main(String[] args) {
        int[] arr = new int[100];
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            arr[i] = random.nextInt(10000);
        }
        selectSort(arr);

        System.out.println(Arrays.toString(arr));

    }
}
