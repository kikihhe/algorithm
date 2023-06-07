package 题目.第一题;


public class Main {
    /**
     * 在数组中查找指定数
     * @param arr 数组
     * @param target 指定数
     * @return 返回指定数在数组中的下标,如果不存在，值为-1
     */
    public static int find(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            // 如果该数与target，返回i(即下标)
            if (arr[i] == target) {
                return i;
            }
        }
        // 如果数组中存在target,那么在上面就应该结束了。
        // 能走到这里就说明target不在arr中，返回-1
        return -1;

    }
    public static void main(String[] args) {
        int[] arr = new int[]{7,9,2,5,7};
        int target = 7;

        int index = find(arr, target);

        if (index >= 0) {
            System.out.println(index);
        } else {
            System.out.println("No");
        }
    }
}
