package 腾讯音乐笔试;


/**
 * 小红拿到了一个仅由"red"组成的字符串，她希望你将所有的'r'变成'e'，'e'变成'd'，'d'变成'r'后，返回这个字符串。
 * 你能帮帮她吗？请注意，这些变化是同时进行的。
 * 字符串长度不超过10^5
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param str string字符串
     * @return string字符串
     */
    public String change (String str) {
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'r') {
                arr[i] = 'e';
            } else if (arr[i] == 'e') {
                arr[i] = 'd';
            } else if (arr[i] == 'd') {
                arr[i] = 'r';
            }
        }
        return new String(arr);
    }
}