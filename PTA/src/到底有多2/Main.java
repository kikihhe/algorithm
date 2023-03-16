package 到底有多2;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        String num = scanner.next();
        double beishu = 1;
        if (num.charAt(0) == '-') {
            beishu = 1.5;
            if (Integer.valueOf(num.charAt(num.length()-1)) % 2 == 0) {
                beishu *= 2;
            }
        }
        int count = 0;
        int all = 0;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '2') {
                count++;
            }
            if (num.charAt(i) >= '0' && num.charAt(i) <= '9') {
                all++;
            }
        }
        double result = count*1.0 / all*1.0 * beishu * 100;
        System.out.printf("%.2f", result);
        System.out.println("%");
        
        
    }
}