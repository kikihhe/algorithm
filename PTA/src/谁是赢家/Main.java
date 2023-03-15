package 谁是赢家;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        // a和b的支持者
        int[] x = new int[3];
        x[scanner.nextInt()]++;
        x[scanner.nextInt()]++;
        x[scanner.nextInt()]++;
        if (a > b) {

            if (x[0] >= 1) {
                System.out.println("The winner is a: "+a+" + "+x[0]);
            } else if(x[1] == 3) {
                System.out.println("The winner is b: "+b+" + "+x[1]);
            }
        } else {
            if(x[1] >= 1) {
                System.out.println("The winner is b: "+b+" + "+x[1]);
            } else if (x[0] == 3) {
                System.out.println("The winner is a: "+a+" + "+x[0]);
            }
        }
    }
}