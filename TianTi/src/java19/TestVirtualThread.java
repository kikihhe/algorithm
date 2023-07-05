package java19;

/**
 * @ClassName TestVirtualThread
 * @Description 尝试Java19虚拟线程
 * @Author 何
 * @Date 2023-07-05 23:18
 * @Version 1.0
 */
public class TestVirtualThread {
    public static void main(String[] args) throws InterruptedException {
        // 平台线程
        Thread platThread = Thread.ofPlatform().unstarted(() -> {
            System.out.println(Thread.currentThread());
        });
        platThread.start();
        platThread.join();
        // 虚拟线程
        Thread virtualThread = Thread.ofVirtual().unstarted(() -> {
            System.out.println(Thread.currentThread());
        });
        virtualThread.start();
        virtualThread.join();


        System.out.println("平台线程的Class: " + platThread.getClass());
        System.out.println("虚拟线程的Class: " + virtualThread.getClass());

    }
}
