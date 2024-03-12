package com.xiaohe.多线程.N个线程不加锁交替打印M个数字;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : 小何
 * @Description :
 * @date : 2024-03-12 10:48
 */
public class Main {
    /**
     * 最大线程数
     */
    private static final int N = 10;
    private static final int M = 100;
    static class MyThread extends Thread {
        /**
         * 当前线程的id，不变
         */
        private int id;
        /**
         * 现在该哪个线程打印了，递增
         */
        private static volatile int now;

        private static final AtomicInteger NUM = new AtomicInteger(0);


        public MyThread(int id) {
            this.id = id;
            this.setName("线程" + id);
        }

        @Override
        public void run() {
            while (NUM.get() < M) {
                if (id != now) {
                    continue;
                } else {
                    System.out.println(Thread.currentThread().getName() + " - " + NUM.getAndIncrement());
                    now = (now + 1) % N;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < N; i++) {
            MyThread myThread = new MyThread(i);
            myThread.join();
            myThread.start();
        }
    }
}


