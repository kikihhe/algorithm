package 单例设计模式.饿汉式;


// 饿汉式设计模式
public class Singleton {
    private Singleton() {

    }

    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }

    
}