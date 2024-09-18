package com.xiaohe.多线程.两个线程交替打印数字;

import java.util.concurrent.ExecutionException;

/**
 * @author : 小何
 * @Description :
 * @date : 2024-03-11 17:23
 */
public class Main {
    public static void main(String[] args) {
        Object lock = new Object();
        Task task = new Task(100, lock);

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        try {
            thread2.join();
            thread1.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        thread1.start();
        thread2.start();


    }
}

class Task implements Runnable {
    /**
     * 当前打印的数字
     */
    private static volatile int i;
    private static volatile int max;
    private volatile Object lock;

    public Task(int max, Object lock) {
        this.max = max;
        this.lock = lock;
    }

    /**
     * 第一个 notify 作用 :
     *      如果没有 notify，1线程抢到锁打印1，然后 wait释放锁，2线程抢到锁打印2然后wait释放锁，这俩线程都wait
     * 第二个 notify 作用 :
     *      如果没有第二个 notify, 1线程 抢到锁，唤醒 2线程，然后打印 99 后 wait 释放锁
     *                          2线程 抢到锁，唤醒 1线程，然后打印 100 后 wait 释放锁
     *                          此时1线程醒着，2线程正在wait，程序无法退出
     */
    @Override
    public void run() {
        while (i < max) {
            synchronized (lock) {
                lock.notifyAll();
                System.out.println(Thread.currentThread().getName() + " - " + (i++));
                try {
                    lock.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                lock.notifyAll();
            }
        }
    }
}
