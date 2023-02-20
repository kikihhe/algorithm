package 过河卒;

import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-10-21 09:42
 */
public class Main {
//    // 错误思路
//    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        // (B1,B2)终点坐标
//        // (M1,M2)马的坐标
//        int B1 = s.nextInt();
//        int B2 = s.nextInt();
//        int M1 = s.nextInt();
//        int M2 = s.nextInt();
//        // 从0开始走
//        int result = process(0,0,B1,B2,M1,M2);
//
//    }
//    private static int process(int i, int j, int B1, int B2, int M1, int M2) {
//        if (i == B1 && j == B2) {
//            return 1;
//        }
//        if (!isValid(i,j,M1,M2)) {
//            return 0;
//        }
//        int result = 0;
//        // 走到最右侧，只能向下走
//        if (j == B2) {
//            result += process(i+1,j,B1,B2,M1,M2);
//        }
//        // 走到最下侧，只能向右走
//        if(i == B1) {
//            result += process(i,j+1,B1,B2,M1,M2);
//        }
//        return process(i+1,j,B1,B2,M1,M2) + process(i,j+1,B1,B2,M1,M2);
//    }
//    private static boolean isValid(int i, int j, int M1, int M2) {
//        if (i == M1 - 1 && j == M2) {
//            return false;
//        }
//        if (i == M1 && j == M2 - 1) {
//            return false;
//        }
//        if (i == M1 + 1 && j == M2) {
//            return false;
//        }
//        if (i == M1 && j == M2 + 1) {
//            return false;
//        }
//        return true;
//    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        double result = process(n);
        System.out.println(result);
    }

    private static double process(int n) {
        if (n == 0) return 0;
        if (n % 2 == 0) {
            return -1.0 / (1.0 * n) + process(n - 1);
        } else {
            return 1.0 / (1.0 * n) + process(n - 1);
        }
    }

}
