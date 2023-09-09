package 单子99;

import java.util.Arrays;
import java.util.List;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-09-09 09:18
 */
public class Main {
    public static void main(String[] args) {
        String[] str = new String[]{
                "aaaa",
                "bbbb",
                "cccc",
                "aabb",
                "aacc"
        };
        List<String> list = Arrays.asList(str);
        list.sort(null);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
