package 算法设计与分析作业.第一次;

public class GCDAlgorithm {
    public static int findGCD(int a, int b) {
        if (b == 0) {
            return a; // 如果b为0，则a即为最大公约数
        }
        return findGCD(b, a % b); // 递归调用求解最大公约数
    }

    public static void main(String[] args) {
        int a = 48;
        int b = 36;
        int gcd = findGCD(a, b);
        System.out.println("最大公约数为：" + gcd);
    }
}
