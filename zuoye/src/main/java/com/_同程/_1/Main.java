package com._同程._1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long mod = 1000000007;
        long oldCount, evenCount;
        if (n % 2 == 0) {
            oldCount = (long) Math.floor(m * 1.0 / 2);
            evenCount = (long) Math.ceil(m * 1.0 / 2);
            long result = (long)( Math.pow(oldCount, n / 2) % mod * Math.pow(evenCount, n / 2)) % mod;
            System.out.println(result);
        } else {
            oldCount = (long) Math.floor(m * 1.0 / 2);
            evenCount = (long) Math.ceil(m * 1.0 / 2);
            long result = (long)( Math.pow(oldCount, (n + 1) / 2) % mod * Math.pow(evenCount, (n - 1) / 2)) % mod;
            System.out.println(result);
        }


    }
}
