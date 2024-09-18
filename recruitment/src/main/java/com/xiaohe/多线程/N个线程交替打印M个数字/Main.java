package com.xiaohe.多线程.N个线程交替打印M个数字;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : 小何
 * @Description :
 * @date : 2024-03-11 17:21
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        MAX = 100;
        for (int i = 0; i < threadCount; i++) {
            MyThread thread = new MyThread(i);
            thread.join();
            thread.start();
        }
    }

    private static int MAX;
    private static int threadCount = 5;

    private static class MyThread extends Thread {

        // 当前打印到多少了，全部线程共享
        private static AtomicInteger NUM = new AtomicInteger(0);
        private static volatile int nowThread;

        // 当前线程id
        private int id;

        public MyThread(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            while (NUM.get() < MAX) {
                if (id != nowThread) {
                    continue;
                } else {
                    System.out.println(id + " 打印了 : " + NUM.getAndIncrement());
                    nowThread = (nowThread + 1) % threadCount;
                }
            }
        }
    }
}
