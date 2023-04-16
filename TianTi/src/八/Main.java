package 八;

import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-04-16 14:08
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] role = new int[N];
        for (int i = 0; i < N; i++) {
            role[i] = scanner.nextInt();
        }
        boolean flag = true;
        while(flag) {
            String str = "";

            for (int i = 0; i <= N; i++) {
                if (i == N) i = 0;
                for (int j = 0; j < role[i]; j++) {
                    str = scanner.next();
                    if ("End".equals(str)) {
                        flag = false;
                    }
                    if (!flag) break;
                    process(str, true);
                }
                if (!flag) break;
                str = scanner.next();
                process(str, false);
            }


        }
    }
    // str: 用户出的
    // win: 此次是否能赢
    public static void process(String str, boolean win) {
        if (str.equals("ChuiZi")) {
            if (win) System.out.println("Bu");
            if (!win) System.out.println("JianDao");
        }
        if (str.equals("JianDao")) {
            if (win) System.out.println("ChuiZi");
            if (!win) System.out.println("Bu");
        }
        if (str.equals("Bu")) {
            if (win) System.out.println("JianDao");
            if (!win) System.out.println("ChuiZi");
        }

    }
}
