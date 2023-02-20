package bite.bite12;

import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-10-20 20:17
 */
public class Main02 {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String N = Integer.toBinaryString(n);
        int max = 0;
        int j = 0;
        char[] arr = N.toCharArray();
        for (int i = arr.length - 1; i >= 0; i --) {
            if (arr[i] == '0') {
                j++;
                max = Math.max(max,j);
            } else {
                j = 0;
            }
        }
        System.out.print(max);
    }
}
