package Lucky_number;

import java.io.IOException;
import java.util.Scanner;


public class Main2 {
    public static void main (String[] args) throws IOException {
        Scanner scanner = new Scanner (System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int count = n >= 2 && k != 2 ? 1 :0;
        for (int i = 3; i <= n; i+=2) {
            if (isPrime(i)) {
                if (!String.valueOf(i).contains(k+"")) count++;
            }
        }
        System.out.println(count);
    }
    // 判断i是不是素数
    public static boolean isPrime(int i) {
        int sign = 1;
        for (int j = 2; j <= (int)Math.sqrt(i) ; j++) {
            if(i % j == 0) {
                sign = 0;
                break;
            }
        }
        return sign == 1;
    }
}
