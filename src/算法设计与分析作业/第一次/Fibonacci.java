package 算法设计与分析作业.第一次;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    // 使用递归实现的Fibonacci算法
    public static long getFibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return getFibonacciRecursive(n - 1) + getFibonacciRecursive(n - 2);
    }

    // 使用记忆化搜索实现的Fibonacci算法
    public static long getFibonacciMemoization(int n) {
        Map<Integer, Long> memo = new HashMap<>();
        return getFibonacciMemoizationHelper(n, memo);
    }

    private static long getFibonacciMemoizationHelper(int n, Map<Integer, Long> memo) {
        if (n <= 1) {
            return n;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        long fib = getFibonacciMemoizationHelper(n - 1, memo) + getFibonacciMemoizationHelper(n - 2, memo);
        memo.put(n, fib);

        return fib;
    }

    public static void main(String[] args) {
        int maxN = 40; // 计算F(n)的最大值

        // 记录不同F(n)值的运行时间
        Map<Integer, Long> recursiveTimes = new HashMap<>();
        Map<Integer, Long> memoizationTimes = new HashMap<>();

        for (int n = 0; n <= maxN; n++) {
            long startTime = System.nanoTime();
            getFibonacciRecursive(n);
            long endTime = System.nanoTime();
            long recursiveTime = endTime - startTime;
            recursiveTimes.put(n, recursiveTime);

            startTime = System.nanoTime();
            getFibonacciMemoization(n);
            endTime = System.nanoTime();
            long memoizationTime = endTime - startTime;
            memoizationTimes.put(n, memoizationTime);
        }

        // 打印不同F(n)值的运行时间
        for (int n = 0; n <= maxN; n++) {
            System.out.println("F(" + n + ") - Recursive Time: " + recursiveTimes.get(n) + " nanoseconds");
            System.out.println("F(" + n + ") - Memoization Time: " + memoizationTimes.get(n) + " nanoseconds");
        }
    }
}
