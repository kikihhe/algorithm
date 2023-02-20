package 传智杯第一题;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String a = s.next();
        String b = s.next();
        if(a.length() == 1 && a.charAt(0) == '0') {
            System.out.println(a);
        }
        else if(b.charAt(0) == '-') {
            // 如果b是负的,a也要是负的
            if(a.charAt(0) != '-') {
                System.out.println('-' + a);
            } else {
                System.out.println(a);
            }
        } else  {
            // 如果b是正的,a也要是正的
            // 如果第一个是'-'，去掉
            if (a.charAt(0) == '-') {
                System.out.println(a.substring(1, a.length()));
            } else {
                System.out.println(a);
            }
        }


    }

}
