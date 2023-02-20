package bite.bite21;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-11-09 17:09
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int i = 0; i < T; i++) {
            int n = s.nextInt();
            int k = s.nextInt();
            int[] arr = new int[2 * n];
            for (int j = 0; j < arr.length; j++) arr[j] = s.nextInt();

            // 洗k次牌
            int[] process = arr;
            for (int j = 0; j < k; j++) {
                process = process(process);
            }
            for (int j = 0; j < process.length;j++) {
                System.out.print(process[j]);
                if(j != process.length-1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }


    }
    private static int[] process(int[] arr) {
        int[] temp = new int[arr.length];
        int flag = 0;
        for (int i = 0, j = arr.length / 2 ; j < arr.length; i++, j++) {
            temp[flag++] = arr[i];
            temp[flag++] = arr[j];
        }
        return temp;
    }
}
