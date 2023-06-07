package 离某个数最近的2次方;

import java.util.Scanner;

/**
 * @ClassName Main
 * @Description 给定一个数，找到离这个数最近的2^x次方, 但是这个2^x要大于给定的数
 * 例如，给定10，那么答案就是16而不是8
 * @Author 何
 * @Date 2023-06-07 16:25
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        n -= 1;
        // 假如一个数为 9
        // 它的二进制为 1001
        // 以下的操作会将第一个1后面的所有二进制位全部置1.
        // 操作后的结果为 1111
        // 再加1，就是 10000，就出来结果了
        // 如果数为 16，二进制为 10000
        // 它在经过下面的运算后就是 11111 + 1 = 100000
        // 与结果不符，所以要将16先减一。
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;

        System.out.println(n+1);


    }
}
