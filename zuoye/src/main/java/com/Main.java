package com;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String[] ipList = new String[n + 1];
        // 将对应编号的IP放到数组中
        for (int i = 0; i < n; i++) {
            String str = scanner.next();
            int id = scanner.nextInt();
            ipList[id] = str;
        }
        Map<String, List<String>> ipMap = new HashMap<>();
        // 构造IP之间的连通性
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            List<String> strings = ipMap.get(ipList[a]);
            if (strings == null) {
                strings = new ArrayList<>();
                ipMap.put(ipList[a], strings);
            }
            strings.add(ipList[b]);
        }
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            String a = scanner.next();
            String b = scanner.next();
            List<String> strings = ipMap.get(a);
            if (strings == null || strings.isEmpty() || !strings.contains(b)) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }

        }
    }
}
