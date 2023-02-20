package bite.bite30;

import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-11-20 11:18
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        for (char a = 'A'; a <= 'Z'; a++) {
            System.out.println(a + " " + (int)a);
        }

        while(s.hasNext()) {
            String str = s.nextLine();
            for (int i = 0; i < str.length(); i++) {
                char a = str.charAt(i);
                if(a >= 65 && a <= 90) {
                    a = (char)( a - 5 < 65 ? a-5+26 : a - 5);
                }
                System.out.print(a);
            }
        }
    }
}
