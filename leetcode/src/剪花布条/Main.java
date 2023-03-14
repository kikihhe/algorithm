package 剪花布条;// write your code here
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String s = scanner.next();
            String t = scanner.next();
            int count = 0;
            // 如果t在s中的位置大于等于0，说明有
            while(s.length() > 0 && s.indexOf(t) >= 0) {
                s = s.substring(s.indexOf(t)+t.length());
                count++;
            }
            System.out.println(count);
            
        }
    }
}