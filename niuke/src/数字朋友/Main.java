package 数字朋友;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-10-29 14:12
 */
public class Main {
    public static void main(String[] args) throws IOException {
        InputStream s = System.in;
        int n = s.read() - 48;
        long[] a = new long[n];
        long[] d = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.read()-48;
            d[i] = s.read()-48;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
            System.out.println(d[i]);
        }

//        for (int i = 0; i < n; i++) {
//            long min = Long.MAX_VALUE;
//            for (int j = 0; j < n; j++) {
//                min = Math.min(min, (long) (a[i] + a[j]) *(a[i]+a[j])+d[i]+d[j]);
//
//            }
//            System.out.print(min+" ");
//        }


    }
}
