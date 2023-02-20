package study;

/**
 *
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出：true
 * 解释："amanaplanacanalpanama" 是回文串。
 *

 */
public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.isPalindrome("0P"));

    }
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase().replaceAll("[^a-z]{0,}", "");
        char[] arr = str.toCharArray();
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            if(arr[i] != arr[j]) {
                return false;
            }
        }
        return true;
    }
}
