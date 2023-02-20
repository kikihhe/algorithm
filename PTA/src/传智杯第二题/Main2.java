package 传智杯第二题;

import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-11-26 18:29
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int max = Math.max(m, n);
        int min = Math.min(m, n);
        int[] arr1 = new int[max + 10];
        int[] arr2 = new int[max + 10];
        int[] answer = new int[max + 10];

        for (int i = n ; i >= 1; i--) arr1[i] = s.nextInt();
        for (int i = m ; i >= 1; i--) arr2[i] = s.nextInt();

        int[] temp = null;
        if (m > n) {
            temp = arr1;
            arr1 = arr2;
            arr2 = temp;
        }
        int t = 0;

        for (int i = 1; i <= min; i++) {
            int a = arr1[i];
            int b = arr2[i];
            int now = (a + b + t) % (i + 1);
            t = (a + b) / (i + 1);
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();



    }
}
