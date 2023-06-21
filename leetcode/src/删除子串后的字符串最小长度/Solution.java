package 删除子串后的字符串最小长度;

class Solution {
    public int minLength(String s) {
        String newString = s;
        while (newString.length() > 0) {
            int index1 = newString.indexOf("AB");
            int index2 = newString.indexOf("CD");
            int index = -1;
            if (index1 != -1 && index2 != -1) {
                index = Math.min(index1, index2);
            } else {
                index = Math.max(index1, index2);
            }
            if (index < 0) {
                break;
            }
            // DSABVDF
            newString = newString.substring(0,index) + newString.substring(index + 2, newString.length());
        }
        return newString.length();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "ABFCACDB";
        System.out.println(solution.minLength(str));
    }
}