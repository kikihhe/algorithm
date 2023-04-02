package 排序.插入排序;

import 排序.Util;

import java.util.Arrays;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-04-02 14:25
 */
public class Main {
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while(j > 0 && arr[j] < arr[j-1]) {
                Util.swap(arr, j, j-1);
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr=  {9,8,1,3,5,1,6,4};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
