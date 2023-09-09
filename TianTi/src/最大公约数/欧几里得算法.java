package 最大公约数;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-09-08 19:14
 */
public class 欧几里得算法 {
    private static int count = 1;
    private static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        System.out.println("第" + (count++) + "次除法");
        return gcd(y, x % y);
    }
    public static void main(String[] args) {
        System.out.println(gcd(113, 13));

    }
}
