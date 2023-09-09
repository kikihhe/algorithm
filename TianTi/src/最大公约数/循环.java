package 最大公约数;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-09-08 19:07
 */
public class 循环 {
    private static int gcd(int x, int y) {
        for (int i = Math.max(x, y); ; i--) {
            if (x % i == 0 && y % i == 0) {
                return i;
            }
        }
    }
    public static void main(String[] args) {
        int a = 1;
        int b = 60;
        System.out.println(gcd(a,b));
    }
}
