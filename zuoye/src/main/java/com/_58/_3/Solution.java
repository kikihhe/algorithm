package com._58._3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         *
         * @param startPos int整型
         * @param endPos int整型
         * @param k int整型
         * @return int整型
         */
        public int numberOfWays (int startPos, int endPos, int k) {
            // write code here
            List<Integer> currentPath = new ArrayList<>();
            dfs(startPos, endPos, k, currentPath);
            return allPaths.size();
        }
    Set<List<Integer>> allPaths = new HashSet<>();
        private void dfs(int current, int end, int remainingSteps, List<Integer> currentPath ) {
            if (remainingSteps == 0) {
                if (current == end && !allPaths.contains(currentPath)) {
                    allPaths.add(new ArrayList<>(currentPath));
                }
                return;
            }
            if (end - current > remainingSteps) {
                return;
            }
            int next1 = current + 1;
            int next2 = current - 1;

            currentPath.add(next1);
            dfs(next1, end, remainingSteps - 1, currentPath);
            currentPath.remove(currentPath.size() - 1);

            currentPath.add(next2);
            dfs(next2, end, remainingSteps - 1, currentPath);
            currentPath.remove(currentPath.size() - 1);

        }
}