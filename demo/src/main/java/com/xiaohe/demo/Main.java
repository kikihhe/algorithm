package com.xiaohe.demo;


public class Main {

    public static int num = 1;
    public static int a = 0;
    public static final Object lock = new Object();

    public static class Worker implements Runnable {
        /**
         * 线程的id
         */
        int id = 0;

        public Worker(int count) {
            this.id = count;
        }

        @Override
        public void run() {
            while (num <= 100) {
                synchronized (lock) {
                    lock.notifyAll();
                    if (a % 3 == id) {
                        System.out.println(id + " -> " + num++);
                        a++;
                        lock.notifyAll();
                    }
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }

        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Worker(1));
        Thread thread2 = new Thread(new Worker(2));
        Thread thread3 = new Thread(new Worker(0));

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
