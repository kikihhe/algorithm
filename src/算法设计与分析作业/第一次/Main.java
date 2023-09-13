package 算法设计与分析作业.第一次;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-09-13 10:38
 */
public class Main {

    public static int findGCD(int[] numbers) {
        int gcd = numbers[0]; // 初始化最大公约数为第一个数
        for (int i = 1; i < numbers.length; i++) {
            gcd = findGCD(gcd, numbers[i]); // 求gcd和下一个数的最大公约数
        }
        return gcd;
    }

    public static int findGCD(int a, int b) {
        if (b == 0) {
            return a; // 如果b为0，则a即为最大公约数
        }
        return findGCD(b, a % b); // 递归调用求解最大公约数
    }

    public static void main(String[] args) {
        int[] numbers = {12, 18, 24, 30, 36}; // 要检测的连续整数序列
        int gcd = findGCD(numbers);
        System.out.println("最大公约数为：" + gcd);
    }


}
