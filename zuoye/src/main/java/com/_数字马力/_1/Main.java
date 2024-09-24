package com._数字马力._1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.next();
        HashMap<Character, List<Integer>> map = new HashMap<>();
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = map.get(arr[i]);
            if (list == null) {
                list = new ArrayList<>();
                map.put(arr[i], list);
            }
            list.add(i + 1);
        }

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                continue;
            }
            set.add(arr[i]);
            List<Integer> list = map.get(arr[i]);
            if (list.size() > 1) {
                for (int i1 = 0; i1 < list.size(); i1++) {
                    Integer index = list.get(i1);
                    System.out.print(arr[i] + ", " + index + "; ");
                }
            }
        }
        
    }
}