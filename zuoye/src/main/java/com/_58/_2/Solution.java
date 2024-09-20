package com._58._2;

public class Solution {
    public static void main(String[] args) {
        String str = "aaaa";
        System.out.println(new Solution().StringSplit(str));
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param str string字符串 
     * @return int整型
     */
    public int StringSplit (String str) {
        // write code here
        // A 得分
        char[] arr = str.toCharArray();
        int[] scoreA = new int[arr.length + 2];
        int[] scoreB = new int[arr.length + 2];
        for (int i = 1; i <= arr.length; i++) {
            if (arr[i - 1] == 'a') {
                scoreA[i] = scoreA[i - 1] + 1;
            } else {
                scoreA[i] = scoreA[i - 1];
            }
        }
        for (int i = scoreB.length - 2; i > 0; i--) {
            if (arr[i - 1] == 'b') {
                scoreB[i] = scoreB[i + 1] + 1;
            } else {
                scoreB[i] = scoreB[i + 1];
            }
        }
        int max = -1;
        for (int i = 1; i < scoreB.length; i++) {
            if (i == 1 && (scoreA[i] == 0 || scoreB[i] == 0)) {
                continue;
            }
            if (i == scoreB.length - 2 &&  (scoreA[i] == 0 || scoreB[i] == 0)) {
                continue;
            }
            max = Math.max(max, scoreA[i] + scoreB[i]);
        }
        return max;
    }
}