package bite.bite30;


import java.util.Scanner;


/**
 * @author : 小何
 * @Description :
 * @date : 2022-11-20 11:33
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while(s.hasNext()) {
            int n = s.nextInt();
            int count = process(n);
            System.out.println(count);
        }


    }
    private static int process(int n) {
        int count = 0;
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                while(n % i == 0) {
                    n /= i;
                }
                count++;
            }
        }
        if(n != 1) count++;
        return count;
    }
    private static int x = 1;


}
class A {
    public static void main(String[] args) {
    }
}
