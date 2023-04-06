package 光棍;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-04-06 22:10
 */
class Matrix{
    int[][] matrix = new int[3][3];
    int row;//行
    int col;//列
    Matrix(int r,int c){//构造函数
        row = r;
        col = c;
    }
}
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        String str = "1";
        BigInteger div = new BigInteger(a + "");
        BigInteger bigInteger = new BigInteger(str);
        while (true) {
            if (bigInteger.mod(div).equals(BigInteger.ZERO)) {
                System.out.println(bigInteger.divide(div) + " " + bigInteger.toString().length());
                break;
            } else {
                str = str + "1";
                bigInteger = new BigInteger(str);
            }
        }

    }
}
