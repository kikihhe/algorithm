package bite.bite05;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main1(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i ++) {
            arr[i] = s.nextInt();
        }
        // sum记录子数组的和，遇到负数置为0
        int sum = 0;
        // 记录最大子数组的和
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i ++) {
            sum += arr[i];
            max = Math.max(sum, max);
            sum = Math.max(sum, 0);
        }
        System.out.println(max);

    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();


    }
}