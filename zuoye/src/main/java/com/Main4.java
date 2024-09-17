package com;

public class Main4 {

    public static void main(String[] args) {
        Main4 main4 = new Main4();
        int[] goodList = new int[]{1500};
        int balance = 1600;
        System.out.println(main4.pickGoods(goodList, balance));
    }

    public int pickGoods(int[] goodList, int balance) {

        process(goodList, 0, 0, balance);
        return max;
    }
    private int max;
    private void process(int[] arr, int index, int sum, int balance) {
        if (index >= arr.length) {
            return;
        }
        sum += arr[index];
        if (sum < balance) {
            max = Math.max(max, sum);
            for (int i = index + 1; i < arr.length; i++) {
                process(arr, i, sum, balance);
            }
        } else {
            return;
        }

    }
}
