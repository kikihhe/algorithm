package 冒泡排序;

import java.util.Arrays;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-04-02 13:43
 */
public class Main {
    // 对arr进行冒泡排序
    public static void bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int flag = 0;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j + 1);
                    flag = 1;
                }
            }
            if(flag == 0) break;
        }
    }
    // 交换数组中两个下标的值
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr=  {9,8,7,6,5,4,3,2,1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
