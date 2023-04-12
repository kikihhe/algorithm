package 作业.作业二;

import java.util.Scanner;


public class Two {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        System.out.println(Math.pow(   Math.abs(x1-x2) * Math.abs(x1-x2) + Math.abs(y1-y2)*Math.abs(y1-y2), 0.5));
    }
}
