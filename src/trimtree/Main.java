package trimtree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = 0; // 及格人数
        int b = 0; // 优秀人数
        int n = scan.nextInt();
        for (int i = 0; i < n; i ++) {
          int score = scan.nextInt();
          if (score >= 60) a++;
          if (score >= 85) b++;
        }
        double a1 = (a * 1.0 / (1.0 * n))* 100;
        double b1 = (b * 1.0 / (1.0 * n))* 100;
        System.out.println(Math.round(a1) + "%");
        System.out.println(Math.round(b1) + "%");
        //在此输入您的代码...
        scan.close();
    }
}