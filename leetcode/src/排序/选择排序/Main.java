package 排序.选择排序;

import java.util.Arrays;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-04-02 14:11
 */
public class Main {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void selectSort(int[] arr) {
        int i = 0;
        int j = 0;
        while(i < arr.length) {
            int max = arr[i];
            int maxIndex = i;
            for (j = i; j < arr.length; j++) {
                if(arr[j] > max) {
                    max = arr[j];
                    maxIndex = j;
                }
            }
            swap(arr, i, maxIndex);
            i++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,4,6,8,2,4,6,9};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
