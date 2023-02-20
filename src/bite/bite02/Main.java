package bite.bite02;

import java.util.Scanner;

public class Main {
    private static int count = 0;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i ++) {
            arr[i] = s.nextInt();
        }

        int i = 0;
        while (i < n) {
            if (i < n-1 && arr[i] == arr[i + 1] ) {
                i ++;
            } else if (i < n-1 && arr[i] < arr[i + 1]) {
                // 递增序列
                i ++;
                while (true) {
                    if (i < n-1 && arr[i] <= arr[i + 1]) {
                        i ++;
                    } else {
                        count ++;
                        i ++;
                        break;
                    }
                }
            } else {
                // 递减序列
                i ++;
                while (true) {
                    if (i < n-1 && arr[i] > arr[i + 1]) {
                        i ++;
                    } else {
                        count ++;
                        i ++;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}