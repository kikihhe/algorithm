package 复读字符串;

import java.util.*;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-11-19 15:37
 */
public class Main {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        while(s.hasNext()) {
            String str = s.next();
            if("0".equals(str)) {
                break;
            }
            if(!set.contains(str)) {
                list.add(str);
            }
            set.add(str);
        }
        String result = "";
        for (String str1: list) {
            result += str1;
        }
        System.out.println(result);
    }
}
