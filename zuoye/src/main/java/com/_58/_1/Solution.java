package com._58._1;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[][] arr1 = new int[][] {
                {0, 3},
                {5, 9},
                {11, 13}
        };
        int[][] arr2 = new int[][] {
                {2, 6},
                {8, 10}
        };
        new Solution().findIntersection(arr1, arr2);

    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * [[0,3],[5,9],[11,13]],[[2,6],[8,10]]
     * 
     * @param firstList int整型二维数组 
     * @param secondList int整型二维数组 
     * @return int整型二维数组
     */
    public int[][] findIntersection (int[][] firstList, int[][] secondList) {
        // write code here
        int[] time = new int[25];
        List<List<Integer>> result = new ArrayList<>();
        addArray(time, firstList);
        addArray(time, secondList);
        // [[2,3],[5,6],[8,9]]
        // 遍历time找 time[i] = 2的
        for (int i = 0; i < 24; ) {
            if (time[i] == 2) {
                int start = i;
                int end = i;
                while (time[end] == 2 && end < 24) {
                    end++;
                }
                i = end;
                List<Integer> list = new ArrayList<>();
                list.add(start);
                list.add(end - 1);
                result.add(list);
            } else {
                i++;
            }
        }
        int[][] resultArr = new int[result.size()][2];
        int count = 0;
        for (List<Integer> list : result) {
            Integer i = list.get(0);
            Integer j = list.get(1);
            resultArr[count][0] = i;
            resultArr[count][1] = j;
            count++;
        }
        return resultArr;
    }

    private void addArray(int[] time, int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            int begin = arr[i][0];
            int end = arr[i][1];
            for (int j = begin; j <= end; j++) {
                time[j] += 1;
            }
        }
    }
}