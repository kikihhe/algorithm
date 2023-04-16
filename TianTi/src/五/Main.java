package 五;

import java.util.*;
public class Main {
    public static int get(int[] arr) {
        int flag = 0;
        for (int i = 6; i > 0; i--) {
            if (arr[i] == 0) {
                flag = i;
                break;
            }
        }
        arr[flag] = 1;
        return flag;
    }
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] map = new int[7][7];
        // 输入六个筛子的初始点数
        for (int i = 1; i <= 6; i++) {
            map[i][scanner.nextInt()]++;
        }
        // 输入第N次
        int n = scanner.nextInt();
        int result = 0;
        for (int i = 1; i <= n; i++) {
            int a = get(map[1]);
            int s = get(map[2]);
            int d = get(map[3]);
            int f = get(map[4]);
            int g = get(map[5]);
            int h = get(map[6]);
            if (i == n) {
                System.out.println( a +" " + s + " " + d + " " + f + " " + g + " " + h);
            }
        }

    }
}