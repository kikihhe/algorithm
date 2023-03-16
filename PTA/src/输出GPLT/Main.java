package 输出GPLT;

import java.util.Locale;
import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-03-16 13:04
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        str = str.toUpperCase(Locale.ROOT);
        int[] map = new int[130];
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'G' || c == 'P' || c == 'L' || c == 'T') {
                count++;
                map[c]++;
            }
        }
        while(count > 0) {
            if (map['G'] != 0) {
                System.out.print('G');
                map['G']--;
                count--;
            }
            if (map['P'] != 0) {
                System.out.print('P');
                map['P']--;
                count--;
            }
            if (map['L'] != 0) {
                System.out.print('L');
                map['L']--;
                count--;
            }
            if (map['T'] != 0) {
                System.out.print('T');
                map['T']--;
                count--;
            }
        }
        System.out.println();
    }
}
