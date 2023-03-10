package 零一串修改;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param str string字符串 
     * @return int整型
     */
    public int minOperations (String str) {
        int a = getCount(str, "0");
        int b = getCount(str, "1");
        return a > b ? b : a;
        
        // write code here
    }
    private int getCount(String str, String flag) {
        int count = 0;
        String[] arr = str.split(flag);
        if (arr.length == 0) return 0;
        for (int i = 0; i < arr.length; i++) {
            count += (arr[i].length() + 1)/2;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int i = s.minOperations("1001101");
        System.out.println(i);
    }
}