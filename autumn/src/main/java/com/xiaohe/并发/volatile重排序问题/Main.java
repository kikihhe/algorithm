package com.xiaohe.并发.volatile重排序问题;


import java.util.concurrent.CountDownLatch;

public class Main {
    public static int x = 0;
    public static int y = 0;
    public static int a = 0;
    public static int b = 0;
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; ; i++) {
            x = 0; y = 0; a = 0; b = 0;
            CountDownLatch countDownLatch = new CountDownLatch(2);
            Thread thread1 = new Thread(() -> {
                a = 1;
                x = b;
                countDownLatch.countDown();
            });
            Thread thread2 = new Thread(() -> {
                b = 1;
                y = a;
                countDownLatch.countDown();
            });
            thread1.start();
            thread2.start();
            countDownLatch.await();
            if (x == 0 && y == 0) {
                System.out.println("第" + i + "次遍历出现问题, x=" + x + ", y=" + y);
            }
        }
    }
}
