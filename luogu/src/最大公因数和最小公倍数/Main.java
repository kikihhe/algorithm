package 最大公因数和最小公倍数;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int x0 = s.nextInt();
        int y0 = s.nextInt();
        int count = 0;
        for (int i = x0; i <= y0; i++) {
            for (int j = y0; j >= x0; j--) {
                if (i * j == x0 * y0 && isMax(y0,i,j) && isSmall(x0,i,j)) {
                    System.out.println(i + " " + j);
                    count ++;
                }
            }
        }
        System.out.println(count);
    }
    // 判断i和j 的最小公约数是不是x0
    private static boolean isSmall(int x0, int i, int j) {
        for (int k = 2; k <= Math.min(i,j); k++) {
            if (i % k == 0 && j % k == 0) {
                return k == x0;
            }
        }
        return false;
    }
    // 判断i和j的最小公倍数是不是y0
    private static boolean isMax(int y0, int i, int j) {
        for (int k = Math.max(i, j); k >= 2; k++) {
            if (k % i == 0 && k % j == 0) {
                return k == y0;
            }
        }
        return false;
    }
}
