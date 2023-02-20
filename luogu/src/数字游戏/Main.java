package 数字游戏;


import java.io.IOException;
import java.io.InputStream;


/**
 * @author : 小何
 * @Description :
 * @date : 2022-10-28 19:33
 */
public class Main {
    public static void main(String[] args) throws IOException {
        InputStream input = System.in;
        int count = 0;
        int read = 0;
        for (int i = 0; i < 8; i++) {
            read = input.read();
            if (read - 48 == 1) {
                count++;
            }

        }
        System.out.println(count);


    }
}
