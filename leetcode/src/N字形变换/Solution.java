package N字形变换;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String convert(String s, int numRows) {
        List<StringBuilder> list = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder(""));
        }
        int i = 0;
        int j = 0;
        boolean flag = true;
        while (j < s.length()) {

            StringBuilder nowString = list.get((i) % numRows);
            char c = s.charAt(j++);
            nowString.append(c);

            // 如果是true,代表正在向下
            if (flag) {
                i++;
            } else {
                i--;
            }
            if (i == numRows-1|| i == 0) flag = !flag;
            // 如果为false,代表正在向上

        }
        StringBuilder result = new StringBuilder();
        for (int x = 0; x < numRows; x++) {
            result.append(list.get(x));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String paypalishiring = solution.convert("PAYPALISHIRING", 4);
        System.out.println(paypalishiring);
    }
}