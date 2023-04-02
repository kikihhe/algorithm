package 排序;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-04-02 14:25
 */
public class Util {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
