package 测试输入输出;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-04-07 21:23
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String s = scanner.readLine();
            System.out.println(s);

        }

    }
}
