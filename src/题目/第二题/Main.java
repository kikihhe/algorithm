package 题目.第二题;



public class Main {
    // 交换数组中的两个数
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 插入排序
     * @param arr 待排序数组
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] > arr[j-1]) {
                swap(arr, j, j - 1);
                j--;
            }

        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 3, 2, 9, 10, 2, 6, 14, 64};
        int[] index = new int[10];
        insertSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("元素" + arr[i] + "插入的位置为: " + i);
        }
    }

}
