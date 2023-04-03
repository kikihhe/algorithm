package 单例设计模式.懒汉式;

/**
 *  单例设计模式-懒汉式
 */
public class Singleton {

    /**
     *
     */
    private Singleton () {
        synchronized (Singleton.class) {
            if (flag) {
                throw new RuntimeException("请勿重复初始化");
            }
            flag = true;
        }


    }
    private static volatile Singleton instance;
    private static boolean flag;

    /**
     * 双重检查锁机制
     * @return
     */
    public static Singleton getInstanceDoubleLock() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    /**
     * 静态内部类方式
     * @return
     */
    public static Singleton getInstanceInnerClass() {
        return SingletonHolder.SINGLETON;
    }
    private static class SingletonHolder {
        private static final Singleton SINGLETON = new Singleton();

    }


}
