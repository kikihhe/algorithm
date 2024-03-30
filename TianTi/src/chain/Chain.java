package chain;

/**
 * @author : 小何
 * @Description : 包含所有的 Handler
 * @date : 2024-03-28 19:36
 */
public class Chain {
    public Handler first = new Handler() {
        @Override
        public void doHandle() {
            System.out.println("虚拟的第一个Handler");
        }
    };

    public Handler end = first;

    public Chain() {

    }

    /**
     * 向尾部添加一个Handler
     * @param handler
     */
    public void addHandler(Handler handler) {
        end.next = handler;
        end = handler;
    }

    public void process() {
        first.handle();
    }
}
