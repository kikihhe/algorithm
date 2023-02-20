package 蓝桥杯第二次模拟赛;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-11-25 12:35
 */
public class Main6 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        HashSet<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String str = s.next();
            if(!set.contains(str)) {
                set.add(str);
                list.add(str);
            }
        }
        for (String s1 : list) {
            System.out.println(s1);
        }

    }
}
