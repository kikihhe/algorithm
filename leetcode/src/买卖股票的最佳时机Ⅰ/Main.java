package 买卖股票的最佳时机Ⅰ;

import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-03-22 20:37
 */
public class Main {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 1) return 0;
        // dp[i][0] 代表彩票的最小价格，将价格变为负数，求最大值就是彩票的最小价格
        // dp[i][1] 代表卖出彩票所获得的最大利润，上一天的利润与当前比较(利润计算方法: dp[i][1] = dp[i-1][0] + prices[i])
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
        }
        return dp[prices.length - 1][1];

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();

        int[] arr = new int[]{7,1,5,3,6,4};
        int i = main.maxProfit(arr);
        System.out.println(i);

    }
}
