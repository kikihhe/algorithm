package bite.bite22;


import java.util.Scanner;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-11-10 17:12
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] map = new int[128];
        String str = s.next();
        char[] arr = str.toCharArray();
        for (char i : arr) {
            map[i]++;
        }
        // 遍历之后map中存储的都是字母的出现次数
        int index = -1;
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 1) {
                index = i;
                break;
            }
        }
        if(index != -1)
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 1) {
                int k = str.indexOf((char)i);
                index = Math.min(index, k);
            }
        }
        System.out.println(arr[index]);
    }
}
