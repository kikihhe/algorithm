package 快排;


import java.util.Arrays;
import java.util.Random;

public class Main {
    private static Random random = new Random();

    /**
     * 选择基准点
     *
     * @param arr   数组
     * @param left  左区间
     * @param right 右区间
     * @return 基准点，下标
     */
    private static int getKey(int[] arr, int left, int right) {
        return arr[random.nextInt(right - left + 1) + left];
    }

    /**
     * 交换两数
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 快排
     *
     * @param arr 待排序数组
     * @param l   左区间
     * @param r   右区间
     */
    public static void quickSort(int[] arr, int l, int r) {
        if (l >= r) return;

        // 找基准点,将数组整理好
        int key = getKey(arr, l, r);
        // left : 整理好后比 key 小的最大的下标 3 2 5 8 11 10, 此处8为key，那么left就代表5的下标
        int left = l - 1;
        // right : 整理好后比 key 大的最小的下标 3 2 5 8 11 10, 此处8为key，那么right就代表11的下标
        int right = r + 1;
        // 使用i进行遍历
        int i = l;
        while (i < right) {
            if (arr[i] < key) {
                swap(arr, i++, ++left);
            } else if (arr[i] == key) {
                i++;
            } else {
                swap(arr, i, --right);
            }
        }
        quickSort(arr, l, left);
        quickSort(arr, right, r);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 2, 8, 6, 0, 9, 10};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
