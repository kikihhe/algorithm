package 蓝桥杯第二次模拟赛;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-11-25 11:34
 */
public class Main3 {
    public static void main(String[] args) {
        for (int i = 10; ; i++) {
            if(process(i)) {
                System.out.println(i);
                break;
            }
        }
    }
    private static boolean process(int i) {
        int num = Integer.parseInt(String.valueOf(i), 16);
        if(num % i == 0) {
            return true;
        }
        return false;
    }
}
