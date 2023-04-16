package 六;

import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-04-16 13:53
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String str = scanner.nextLine();
            if (str.endsWith("?") ) {
                if (str.contains("PTA")) {
                    System.out.println("Yes!");
                } else {
                    System.out.println("No.");
                }
            } else {
                System.out.println("enen");
            }
        }
    }
}
