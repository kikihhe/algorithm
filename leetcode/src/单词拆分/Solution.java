package 单词拆分;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        String word = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("lee");
        wordDict.add("code");
        Solution s = new Solution();
        boolean b = s.wordBreak(word, wordDict);
        System.out.println(b);

    }
}