package 矩阵;

import java.util.*;
public class Main {
    public static int[][] cal(int[][] x1, int[][] x2) {
        int[][] result = new int[x1.length][x2[0].length];
        for (int i = 0; i < x1.length; i++) {
            for (int j = 0; j < x2[0].length; j++) {
                result[i][j] = 0;
                for (int k = 0; k < x1[0].length; k++) {
                    result[i][j] += x1[i][k] * x2[k][j];
                }
            }
        }
        return result;
        
        
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 第一个矩阵的行和列
        int Ra = scanner.nextInt();
        int Ca = scanner.nextInt();
        int[][] x1 = new int[Ra][Ca];
        for (int i = 0; i < Ra; i++) {
            for (int j = 0; j < Ca; j++) {
                x1[i][j] = scanner.nextInt();
            }
        }
        // 第二个矩阵的行和列
        int Rb = scanner.nextInt();
        int Cb = scanner.nextInt();
        int[][] x2 = new int[Rb][Cb];
        for (int i = 0; i < Rb; i++) {
            for (int j = 0; j < Cb; j++) {
                x2[i][j] = scanner.nextInt();
            }
        }
        
        if (Ca != Rb) {
            System.out.println("Error: Ca != Rb");
        } else {
            int[][] result = cal(x1, x2);
            System.out.println(result.length + " " + result[0].length);
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    System.out.print(result[i][j]);
                    if (j != result[0].length-1) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
}