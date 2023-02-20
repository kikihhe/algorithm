package 抢红包;


import java.util.Comparator;
import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-11-21 11:24
 */
public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        // N[i]代表第i个人抢到的红包钱数
        int[] jishu = new int[n + 1];
        for(int i = 0; i < jishu.length; i++) jishu[i]=i;
        int[] N = new int[n + 1];
        int[] count = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int k = s.nextInt();
            // k是有多少个红包
            for (int j = 1; j <= k; j++) {
                // 第j个红包被谁抢了
                int a = s.nextInt();
                count[a]++;
                // 第i个红包有多少钱
                int b = s.nextInt();
                N[a] += b;
                N[i] -= b;
            }

        }
        // 降序排序
        int maxIndex = 0;
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = N[i];
            maxIndex = i;
            for (int j = i; j <= n; j++) {
                if(N[j] > max) {
                    max = N[j];
                    maxIndex = j;
                }
                else if(N[j] == max) {
                    maxIndex = count[j] > count[maxIndex] ? j : maxIndex;
                    if(count[j] == count[maxIndex]) {
                        maxIndex = jishu[j] < jishu[maxIndex] ? j : maxIndex;
                    }
                }
            }
            int temp1 = N[i];
            N[i] = N[maxIndex];
            N[maxIndex] = temp1;
            int temp2 = jishu[i];
            jishu[i] = jishu[maxIndex];
            jishu[maxIndex] = temp2;
            int temp3 = count[i];
            count[i] = count[maxIndex];
            count[maxIndex] = temp3;
        }

        for(int i = 1; i < N.length;  i ++) {
            System.out.printf("%d %.2f\n", jishu[i], N[i] * 1.0 / 100);
        }
    }
}
