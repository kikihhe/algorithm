package com.xiaohe.贪心.找零问题;

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fiveCount = 0;
        int tCount = 0;

        for (int i = 0; i < bills.length; i++) {
            // 如果是5元，直接加上
            if (bills[i] == 5) {
                fiveCount++;
            } else if (bills[i] == 10) {
                // 如果是 10 元，如果5个数足够，5-- 10++
                if (fiveCount <= 0) {
                    return false;
                } else {
                    fiveCount--;
                    tCount++;
                }
            } else {
                // 如果是20元
                // 先 10 + 5 的策略
                // 再 5 + 5 + 5 的策略
                if (fiveCount > 0 && tCount > 0) {
                    fiveCount--;
                    tCount--;
                } else if (fiveCount > 2) {
                    fiveCount -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {5,5,10,10,20};
        System.out.println(new Solution().lemonadeChange(arr));
    }
}