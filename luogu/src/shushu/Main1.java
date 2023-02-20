package shushu;

import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-10-30 11:44
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int count = 0;
        for (int z = 1; z <= n; z++) {
            for (int y = 1; y <= z; y++) {
                for (int x = 1; x <= y; x++) {
                    if (y % x == 0 && z % y == 0 && GCD(y/x, z/y) == 1) {
                        count ++;
                    }
                }
            }
        }
        System.out.println(count % 998244353);

    }
    // 计算最大公约数
    private static int GCD(int a, int b) {
        int temp;
        while (b != 0) {
            temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
