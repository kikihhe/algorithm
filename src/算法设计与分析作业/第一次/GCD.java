package 算法设计与分析作业.第一次;

import java.util.concurrent.TimeUnit;

public class GCD {
    // 使用减法实现的欧几里得算法
    public static int findGCDBySubtraction(int m, int n) {
        while (m != n) {
            if (m > n) {
                m = m - n;
            } else {
                n = n - m;
            }
        }
        return m;
    }

    // 使用除法实现的欧几里得算法
    public static int findGCDByDivision(int m, int n) {
        while (n != 0) {
            int remainder = m % n;
            m = n;
            n = remainder;
        }
        return m;
    }

    public static void main(String[] args) {
        int m = 123456789;
        int n = 987654321;

        long startTime = System.nanoTime();
        int gcdBySubtraction = findGCDBySubtraction(m, n);
        long endTime = System.nanoTime();
        long subtractionDuration = endTime - startTime;

        startTime = System.nanoTime();
        int gcdByDivision = findGCDByDivision(m, n);
        endTime = System.nanoTime();
        long divisionDuration = endTime - startTime;

        System.out.println("最大公约数 (使用减法): " + gcdBySubtraction);
        System.out.println("最大公约数 (使用除法): " + gcdByDivision);
        System.out.println("减法耗时: " + subtractionDuration + " 纳秒");
        System.out.println("除法耗时: " + divisionDuration + " 纳秒");
    }
}
