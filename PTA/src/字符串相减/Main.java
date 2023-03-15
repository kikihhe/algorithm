package 字符串相减;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        char[] map = new char[128];
        for (int i = 0; i < b.length(); i++) {
            map[b.charAt(i)]++;
        }
        for (int i = 0; i < a.length(); i++)  {
            if (map[a.charAt(i)] == 0) {
                System.out.print(a.charAt(i));
            }
        }
    }
}