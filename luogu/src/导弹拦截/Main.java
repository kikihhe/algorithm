package 导弹拦截;

import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-10-22 15:50
 */
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] arr = new int[100001];
        int n = 0;
        while (s.hasNext()) {
            arr[n++] = s.nextInt();
        }
        int count = 1;
        count = process(arr, n,1, arr[0]);
        System.out.println(count);
    }

    private static int process(int[] arr,int n, int i, int max) {
        if (i == n) {
            return 0;
        }
        int count = 0;
        // 这个导弹你拦截不拦截


        return 0;
    }

}
