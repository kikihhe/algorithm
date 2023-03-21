package 字符串全排列;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-03-21 22:34
 */
public class Main {
    private static Set<String> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            boolean[] has = new boolean[str.length()];
            process(arr, i, "", has);
        }
        set.forEach(System.out::println);
    }

    /**
     *
     * @param arr 需要遍历的数组
     * @param index 当前遍历的位置
     */
    public static void process(char[] arr, int index, String now, boolean[] has) {
        if (index < 0 || index >= arr.length || now.length() == arr.length) return ;
        String n = now + arr[index];
        if (!has[index]) {
            set.add(n);
            has[index] = true;
        }
        for (int i = 0; i < arr.length; i++) {
            if (i != index && !has[i]) {
                process(arr, i, n, has);
                has[i] = false;
            }
        }
    }
}