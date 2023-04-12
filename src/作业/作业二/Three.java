package 作业.作业二;

import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-04-12 23:10
 */
public class Three {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the radius of the sphere: ");
        // Math.PI --> Π
        double r = scanner.nextDouble();
        double c = 2 * Math.PI * r;
        double v = 4.0 / 3 * Math.PI * Math.pow(r, 3);
        double s = 4 * Math.PI * Math.pow(r, 2);
        System.out.println("Circumference : " + c);
        System.out.println("Volume : " + v);
        System.out.println("Surface Area : " + s);
    }
}
