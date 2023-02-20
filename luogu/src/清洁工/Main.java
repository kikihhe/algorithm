package 清洁工;

import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-11-19 16:56
 */
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int x = s.nextInt();
        int y = s.nextInt();
        x = n - x + 1;
        int[][] arr = new int[n][n];
        int[][] flag = new int[n][n];
        for(int i = 0; i < flag.length; i++)
            for(int j = 0; j < flag[0].length; j++)
                flag[i][j] = 1;
        String str = s.next();
        for(int i = 0; i < m; i++) {
            luohui(arr, flag,x - 1, y - 1, i);
            if(str.charAt(i) == 'N') {
                x--;
            }
            if(str.charAt(i) == 'S') {
                x++;
            }
            if(str.charAt(i) == 'W') {
                y--;
            }
            if(str.charAt(i) == 'E') {
                y++;
            }


        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }


    }
    // 在(x-1, y-1)位置,其他位置+i
    private static void luohui(int[][] arr, int[][] flag, int x, int y, int i) {
        for(int a = 0; a < arr.length; a++) {
            for (int b = 0; b < arr[0].length; b++) {
                if(a == x && b == y) {
                    continue;
                }
                arr[a][b] = arr[a][b] + flag[a][b];
                flag[a][b] += 1;
            }
        }
    }
}
