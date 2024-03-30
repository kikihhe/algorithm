package chain;

/**
 * @author : 小何
 * @Description :
 * @date : 2024-03-28 19:42
 */
public class Main {
    public static void main(String[] args) {
        Chain chain = new Chain();
        Handler handler1 = new Handler() {
            @Override
            public void doHandle() {
                System.out.println("第一个Handler");
            }
        };
        Handler handler2 = new Handler() {
            @Override
            public void doHandle() {
                System.out.println("第二个Handler");
            }
        };
        chain.addHandler(handler1);
        chain.addHandler(handler2);

        chain.process();
    }
}
