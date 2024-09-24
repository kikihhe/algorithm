package com._同程._2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * registration complete
 * illegal length
 * acount existed
 * illegal charactor
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> set = new HashSet<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String str = scanner.next();
            if (str.length() < 6 || str.length() > 12) {
                System.out.println("illegal length");
                continue;
            }
            if (!process(str)) {
                System.out.println("illegal charactor");
                continue;
            }
            if (set.contains(str)) {
                System.out.println("acount existed");
                continue;
            }
            set.add(str);
            System.out.println("registration complete");
        }

    }

    private static boolean process(String str) {
        for (char i : str.toCharArray()) {
            if (i >= 'a' && i <= 'z' || i >= 'A' && i <= 'Z') {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
