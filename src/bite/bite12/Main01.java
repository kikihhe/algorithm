package bite.bite12;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-10-20 19:58
 */
public class Main01 {
    public int getLCA(int a, int b) {
        if (a == 1 || b == 1) {
            return 1;
        }
        if (a == b) return a;
        if (a > b * 2) return getLCA(a/ 2, b);
        if (b > a * 2) return getLCA(a,b / 2);
        return getLCA(a / 2, b / 2);
    }
    public static void main(String[] args) {
        Main01 main01 = new Main01();
        System.out.println(main01.getLCA(57530,209947));
    }

    public static int abc (int a, int b) {

            while (a != b) {
                if (a > b) {
                    a /= 2;
                } else {
                    b /= 2;
                }
            }
            return a;

    }
}
