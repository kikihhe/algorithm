package 红与黑;

import java.util.Locale;
import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-03-20 19:24
 */
public class Main {
    private static int count = 0;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            count = 0;
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            char[][] arr = new char[m][n];
            int a = 0;
            int b = 0;
            // m行n列的迷宫
            for (int i = 0; i < m; i++) {
                String str = scanner.next();
                arr[i] = str.toCharArray();
                if (str.contains("@")) {
                    a = i;
                    b = str.indexOf("@");
                }
            }

            process(arr, a, b);
            System.out.println(count);

        }

    }


    private static void process(char[][] arr, int a, int b) {
        // 如果走到边界，直接结束
        if (a < 0 || b < 0 || a >= arr.length || b >= arr[a].length || arr[a][b] == '#') return;

        // 如果当前的位置没有走过并且是黑色砖 .
        count++;
        arr[a][b] = '#';


        process(arr, a, b - 1);


        process(arr, a, b+1);


        process(arr, a-1, b);


        process(arr, a + 1, b);


    }

}
