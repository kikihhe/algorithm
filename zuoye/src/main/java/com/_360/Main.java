package com._360;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            process();
        }

    }
    public static void process() {
        // n座山
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        if (n == 0) {
            System.out.println(0);
        } else if (n == 1) {
            System.out.println(1);
        } else {
            p(arr, 0, new ArrayList<>(), true);
        }
        System.out.println(max);
    }
    static int max = 0;
    static List<List<Integer>> result = new ArrayList<>();
    // index: 当前位置
    //
    private static void p(int[] arr, int index, List<Integer> list, boolean flag) {
        if (index == arr.length) {
            result.add(new ArrayList<>(list));
            max = Math.max(max, list.size());
            return;
        }
        // 一个都没选
        if (list.size() == 0) {
            p(arr, index + 1, list, flag);
            list.add(arr[index]);
            p(arr, index + 1, list, flag);
            list.remove(list.size()-1);
            return;
        }
        if (arr[index] == list.get(list.size()-1)) {
            return;
        } else if (arr[index] > list.get(list.size()-1)) {
            // 不选
            p(arr, index + 1, list, flag);
            // 选
            list.add(arr[index]);
            p(arr, index + 1, list, flag);
            list.remove(list.size()-1);
        } else {
            // 这座山比之前的山矮, 可以将其变高
            // 不适用神力
            p(arr, index + 1, list, flag);

            // 使用神力

            list.add(list.get(list.size()-1)+1);
            p(arr, index + 1, list, false);
            list.remove(list.size()-1);
        }

    }
}
