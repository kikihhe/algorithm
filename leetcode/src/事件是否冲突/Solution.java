package 事件是否冲突;

import java.text.SimpleDateFormat;
import java.util.Date;

class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {

        int start1 = parse(event1[0]);

        int end1 = parse(event1[1]);

        int start2 = parse(event2[0]);

        int end2 = parse(event2[1]);

        if (start1 < start2) {
            return start2 <= end1;

        } else {
            return start1 <= end2;
        }



    }
    // 返回的数组，[0]是小时 [1]是分钟
    private int parse(String time) {
        String[] arr = time.split(":");
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
        }
        return Integer.parseInt(result);
    }
}