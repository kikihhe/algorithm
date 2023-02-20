package Lucky_number;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-10-30 09:31
 */
public class Main1 {
    public static int N = 100010, count = 0;
    public static int[] primes = new int[N];
    public static boolean[] st = new boolean[N];

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        isPrime(n);
        System.out.println(Arrays.toString(primes));
        int i = 0;
        // 计算数字中不包含k的个数
        int count1 = 0;
        while(primes[i] != 0) {
            String str = primes[i] + "";
            if (!str.contains(String.valueOf(k))) {
                count1++;
            }
            i++;
        }
        System.out.println(count1);
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }
    public static void isPrime(int n) {
        for (int i = 2; i<=n; i++) {
            if (!st[i]) {
                primes[count++] = i;
            }
            for (int j = i+i; j<=n; j+=i) st[j] = true;    //注意起始为i+i，也就是2*i, 当然写i其实也不影响
        }
    }

}
