package com;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        long eq = 0;
        long less = 0;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String s1 = scanner.next();
            set.add(s1);
        }
        eq = set.stream().filter(str -> str.length() == s.length()).count();
        less = set.stream().filter(str -> str.length() < s.length()).count();
        System.out.println(less + 1);
        System.out.println(eq + less);
    }
}
