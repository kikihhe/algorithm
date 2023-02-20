package bite.bite27;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-11-16 10:32
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(s.hasNext()) {
            String str1 = s.next();
            String str2 = s.next();
            String str3 = s.next();
            BigInteger a = new BigInteger(str1);
            BigInteger b = new BigInteger(str2);
            BigInteger c = new BigInteger(str3);
            if(a.add(b).compareTo(c) > 0 && b.add(c).compareTo(a) > 0 && c.add(a).compareTo(b) > 0 ) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
