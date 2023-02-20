package Lucky_number;

import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-10-30 09:08
 */
public class Main {
    public static int T = 100010, count = 0;
    public static int[] prime = new int[T];
    public static boolean[] ts = new boolean[T];


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        // 先计算出所有素数
        allPrimes(n);
        // 迭代
        int i = 0;
        // 计算数字中不包含k的个数
        int count1 = 0;
        while(prime[i] != 0) {
            String str = prime[i] + "";
            if (!str.contains(String.valueOf(k))) {
                count1++;
            }
            i++;
        }
        System.out.println(count1);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    // 计算n以内所有素数
    public static void allPrimes(int n) {
        for (int i = 2; i <= n; i++){
            if (!ts[i]) {
                prime[count++] = i;
            }

            for (int j = 0; prime[j] <= n/i; j++){
                ts[prime[j] * i] = true;
                if (i % prime[j] == 0) break;
            }
        }
    }

}
