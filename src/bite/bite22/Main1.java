package bite.bite22;

import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-11-10 17:11
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(s.hasNext()) {
            // 怪物的数量
            int n = s.nextInt();
            // 小易的初始武力值
            int a = s.nextInt();
            int[] b = new int[n];
            // 输入每一个怪物的防御
            for (int i = 0; i < b.length; i++) b[i] = s.nextInt();
            for (int i = 0; i < b.length; i++) {
                if(a >= b[i]) {
                    a += b[i];
                } else {
                    a += yue(a, b[i]);
                }
            }
            System.out.println(a);

        }



    }

    // 求a和b的最大公约数
    private static int yue(int a, int b) {
        int r = 1;
        while(b != 0) {
            r = a % b;
            a = b;
            b = r;
        }

        return a;
    }
}
