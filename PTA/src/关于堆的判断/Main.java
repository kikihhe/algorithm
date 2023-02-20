package 关于堆的判断;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-11-21 13:19
 */
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        PriorityQueue<Integer> dui = new PriorityQueue<>();
        int N = s.nextInt();
        int M = s.nextInt();
        // 输入小根堆
        for (int i = 0; i < N; i++) {
            dui.add(s.nextInt());
        }
        Object[] objects = dui.toArray();
        int[] arr = new int[objects.length];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = (Integer) objects[i];
        }
        s.nextLine();
        for (int i = 0; i < M; i++) {
            String problem = s.nextLine();
            System.out.println(getNums(problem, arr));
        }

    }
    private static String getNums(String str, int[] arr) {
        String[] a = str.split(" ");
        int i = 0;
        int j = 0;
        if(str.contains("root")) {
            i = Integer.parseInt(a[0]);
            return i == arr[0] ? "T" : "F";

        } else if(str.contains("siblings")) {
            i = Integer.parseInt(a[0]);
            j = Integer.parseInt(a[2]);
            if(i % 2 == 0 && i + 1 == j || j % 2 == 0 && j + 1 == i) {
                return "T";
            } else {
                return "F";
            }

        } else if(str.contains("parent")) {
            i = Integer.parseInt(a[0]);
            j = Integer.parseInt(a[5]);
            return j / 2 == i ? "T" : "F";

        } else  {
            i = Integer.parseInt(a[0]);
            j = Integer.parseInt(a[5]);
            return i / 2 == j ? "T" : "F";
        }




    }
}
