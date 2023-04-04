package 古风排版;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-04-04 21:52
 */
import java.util.*;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        String str = scanner.nextLine();
        int x = N;
        int y = str.length() / N + 1;
        char[][] arr = new char[x][y];
        int flag = 0;
        for (int i = y-1; i >= 0; i--) {
            for (int j = 0; j < x; j++) {
                if (flag >= str.length()) {
                    arr[j][i] = ' ';
                }
                else {
                    arr[j][i] = str.charAt(flag++);
                }

            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {

                System.out.print(arr[i][j]);

            }

            System.out.println();
        }

    }
}