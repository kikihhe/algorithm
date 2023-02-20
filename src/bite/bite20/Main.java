package bite.bite20;

import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-11-08 13:00
 */
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str1 = s.next();
        String str2 = s.next();

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        System.out.println(process(arr1, arr2));



    }
    private static int process(char[] arr1, char[] arr2) {
        int max = 0;
        int[][] dp = new int[arr1.length + 1][arr2.length + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (arr1[i-1] == arr2[j-1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max;



    }
}
