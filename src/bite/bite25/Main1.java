package bite.bite25;

import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-11-14 11:10
 */
public class Main1 {
    private static int[] fib = new int[10005];
    // 初始化斐波那契数列
    private static void Fib() {
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i < fib.length; i++) {
            fib[i] = (fib[i-1] + fib[i-2]) % 10000;
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Fib();
        while(s.hasNext()) {
            int n = s.nextInt();
            for (int i = 0; i < n; i++) {
                int k = s.nextInt();
                System.out.print(process(fib[k]));
            }
            System.out.println();
        }
    }
    // 处理第K项数，不足4位则补0
    private static String process(int k) {
        String result = k + "";
        while(result.length() < 4) {
            result = "0" + result;
        }
        return result;
    }


}
