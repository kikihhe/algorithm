package bite.bite04;

import java.math.BigInteger;
import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        int n = s.nextInt();
        int base = 10;
        int to = n;
        System.out.println(new BigInteger(str,base).toString(to));
//        // 十进制数
//        int M = in.nextInt();
//        // 进制
//        int N = in.nextInt();
//        List<String> list = new ArrayList<>();
//        int m = 0;
//        while (M != 0) {
//            m = M % N;
//            M = M / N;
//            if (m >= 10) {
//                list.add(String.valueOf((char)(m + 55)));
//            } else {
//                list.add(String.valueOf(m));
//            }
//        }
//        Collections.reverse(list);
//        for(String str : list) {
//            System.out.print(str);
//        }


    }
}