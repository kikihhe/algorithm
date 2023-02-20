package bite.bite19;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-11-07 11:21
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str1 = s.next();
        String str2 = s.next();
        // 让str1保持最小
        if (str1.length() > str2.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        // 记录最大字串的位置
        int index = 0;
        // 记录最大字串个数
        int max = 0;
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for (int i = 1; i < str1.length() + 1; i++) {
            for (int j = 1; j < str2.length()+1; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        index = j;
                    }
                }
            }
        }
        System.out.println(str2.substring(index - max,index));

    }
}
