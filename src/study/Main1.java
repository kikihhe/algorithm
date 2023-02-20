package study;

import java.util.*;
public class Main1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(); // 数组长度
        int m = s.nextInt(); // 操作次数
        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        for(int i = 0; i < m; i++) {
            // 输入操作类型, 0使1-q降序，1使q-n升序
            int p = s.nextInt();
            // q代表操作下标，1-q, q-n
            int q = s.nextInt();
            if (p == 0) {
                Arrays.sort(arr, 0, q, new MyComparator());
            } else if (p == 1) {
                Arrays.sort(arr, q - 1, n);
            }


        }
        for (int i : arr) {
            System.out.print(i + " ");
        }

        s.close();
    }
}
class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}