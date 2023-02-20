package bite.bite25;

import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-11-14 10:37
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(s.hasNext()) {
            String n = s.next();
            while(n.length() != 1) {
                n = process(n);
            }
            System.out.println(n);
        }


    }
    // 将s的每一位相加
    private static String process(String s) {
        String sum = "";
        char[] arr = s.toCharArray();
        int i = 0;
        int j = 1;
        while(i < arr.length) {
            int k = 0;
            if(j < arr.length) {
                k += arr[j] - '0';
            }
            k += arr[i] - '0';
            sum += k;
            i+=2;
            j+=2;
        }
        return sum;
    }
}
