package chain;

/**
 * @author : 小何
 * @Description :
 * @date : 2024-03-28 19:36
 */
public abstract class Handler {
    public Handler next;
    public abstract void doHandle();

    public void handle() {
        this.doHandle();
        if (next != null) {
            next.handle();
        }
    }
}
