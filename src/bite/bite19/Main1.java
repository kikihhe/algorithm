package bite.bite19;

import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-11-07 11:05
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(s.hasNext()) {
            int n = s.nextInt();
            if (n == 0) break;
            // 计算能喝多少瓶水
            System.out.println(n/2);
        }
    }
}
