package 好时刻;

import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-11-19 15:46
 */
public class Main {
    private static int count = 0;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int day = -1;
        int h = 0;
        int m = 0;
        for (int i = 0; i <= n; i++) {
            int x = i;
            if (x > 1440) x = x % 1440 - 1;
            h = 0;
            m = x;
            if(m > 59) {
                h = m / 60;
                m %= 60;
            }
            if (isGood(h,m)) count++;
        }

//        int x =(int)Math.ceil(n*1.0/1440);
//
//        for (int r = 0; r < x; r++) {
//
//        }
//        for(int i = 0; i <= 23; i++) {
//            for (int j = 0; j <= 59; j++) {
//                if(i * 60 + j > n) break;
//
//                if(isGood(i, j)) {
//                    count++;
//                }
//
//
//            }
//        }
        if(n%1440 == 0)count++;
        System.out.println(count);
    }
    // i : 小时
    // j : 分钟
    private static boolean isGood(int i, int j) {
        int a = i/10;
        int b = i%10;
        int c = j/10;
        int d = j%10;
        if(i >= 10) {
            return a-b == b-c && b-c == c-d;
        } else {
            return b-c == c-d;
        }

    }
}
