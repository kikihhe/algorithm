package 线程死锁;

/**
 * @ClassName Main
 * @Description 演示线程死锁
 * @Author 何
 * @Date 2023-08-02 09:46
 * @Version 1.0
 */
public class Main {
    private static Object A = new Object();
    private static Object B = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (A) {
                System.out.println(Thread.currentThread().getName() + "抢到A");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + "想要B");
                synchronized (B) {
                    System.out.println(Thread.currentThread().getName() + "抢到B");
                }
            }
        }, "线程1").start();

        new Thread(() -> {
            synchronized (B) {
                System.out.println(Thread.currentThread().getName() + "抢到B");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + "想要A");
                synchronized (A) {
                    System.out.println(Thread.currentThread().getName() + "抢到A");
                }
            }
        }, "线程2").start();





    }
}
