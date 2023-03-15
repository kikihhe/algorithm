package 念数字;

import java.util.*;
//0: ling
//        1: yi
//        2: er
//        3: san
//        4: si
//        5: wu
//        6: liu
//        7: qi
//        8: ba
//        9: jiu

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        if (a < 0) {
            System.out.print("fu ");
            a = -a;
        }
        String str = a + "";
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case '0':
                    System.out.print("ling");
                    break;
                case '1':
                    System.out.print("yi");
                    break;
                case '2':
                    System.out.print("er");
                    break;
                case '3':
                    System.out.print("san");
                    break;
                case '4':
                    System.out.print("si");
                    break;
                case '5':
                    System.out.print("wu");
                    break;
                case '6':
                    System.out.print("liu");
                    break;
                case '7':
                    System.out.print("qi");
                    break;
                case '8':
                    System.out.print("ba");
                    break;
                case '9':
                    System.out.print("jiu");
                    break;

            }
            if(i != str.length()-1) System.out.print(" ");
            
        }

    }
}