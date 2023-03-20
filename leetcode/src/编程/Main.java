package 编程;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-03-19 12:10
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int[] map = new int[100];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            map[arr[i]]++;
        }

        //
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 1) {
                System.out.println(i);
            }
        }

//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < n; i ++) {
//            int a = scanner.nextInt();
//            if (!map.containsKey(a)) {
//                map.put(a, 1);
//            } else {
//                Integer integer = map.get(a);
//                map.put(a, integer+1);
//            }
//        }
//        map.forEach((a, b) -> {
//            if (b == 1) {
//                System.out.println(a);
//            }
//        });
    }
}
