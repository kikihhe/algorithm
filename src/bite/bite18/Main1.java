package bite.bite18;

import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-10-29 15:59
 */
public class Main1 {
    public static void main(String[] a) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        if (n == 1) {
            System.out.println(1);
        } else if (n == 2) {
            System.out.println(2);
        } else {
            int[] dp = new int[n+1];
            dp[1] = 1;
            dp[2] = 1;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i-1]+dp[i-2];
            }
            System.out.println(dp[n]);

        }

    }
}
