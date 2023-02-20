package 阶乘之和;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-10-24 11:08
 */
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        BigInteger sum = new BigInteger("0");
        for (int i = 1; i <= n; i++) {
            sum = sum.add(func(i));
        }

        System.out.println(sum);
    }
    private static BigInteger func(int n) {

        BigInteger f = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            f = f.multiply(new BigInteger(String.valueOf(i)));
        }
        return f;
    }
}
