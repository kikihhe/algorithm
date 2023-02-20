package bite.bite09;

import java.util.Scanner;


public class Main1 {
//     测试递归
    public static void main(String[] args) {

        Scanner s = new  Scanner(System.in);
        int M = s.nextInt();
        int N = s.nextInt();
        int[][] arr = new int[M][N];
        System.out.println(process(arr, 0,0));
        System.out.println(process1(M, N));
    }

    // 记忆化搜索
    public static int process1(int M, int N) {
        int[][] arr = new int[M + 1][N + 1];
        for (int j = 0; j <= N; j ++) arr[M][j] = 1;
        for (int i = 0; i <= M; i ++) arr[i][N] = 1;
        for (int i = M - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                arr[i][j] = arr[i + 1][j] + arr[i][j + 1];
            }
        }
        return arr[0][0];
    }

    // 递归
    public  static int process(int[][] arr, int i, int j) {
        if (i == arr.length && j == arr[0].length) {
            return 1;
        }
        int result = 0;
        if (i == arr.length) {
            result = process(arr, i, j+1);
        } else if (j == arr[0].length) {
            result = process(arr, i+1, j);
        } else {
            result = process(arr,i+1,j) + process(arr,i,j+1);
        }
        return result;
    }


}
