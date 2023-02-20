package 抽奖;

import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-11-11 19:45
 */
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] arr = new int[]{-1,0,1,2,-1,-4,1};
        int n = arr.length;

        // [-1,0,1,2,-1,-4,1]
        System.out.println(process(n, arr, 0, 0, 0));
    }
    public static int process(int n,int[] arr, int index, int count, int sum) {
        if(index >= n) return 0;
        // 如果抽奖次数为0且sum为0，则中将
        if(count == 3 && sum == 0) {
            return 1;
        }
        int result = 0;
        // 到了index位置，拿不拿?
        // 结果为拿+不拿
        result = process(n, arr, index + 1, count+1, sum + arr[index])
                +process(n, arr, index + 1, count, sum);

        return result;
    }
}
