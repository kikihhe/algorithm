package 两个栈模拟队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Main
 * @Description 两个栈模拟队列
 * @Author 何
 * @Date 2023-06-12 09:49
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        CQueue cQueue = new CQueue();

        int i1 = cQueue.deleteHead();
        System.out.println(i1);


    }
}
class CQueue {
    private Queue<Integer> deleteQueue;
    private Queue<Integer> addQueue;

    public CQueue() {
        deleteQueue = new LinkedList<>();
        addQueue = new LinkedList<>();

    }

    public void appendTail(int value) {
        addQueue.offer(value);
    }

    public int deleteHead() {
        if (deleteQueue.isEmpty()) {
            while(!addQueue.isEmpty()) {
                deleteQueue.offer(addQueue.poll());
            }
        }
        if (deleteQueue.isEmpty()) {
            return -1;
        }
        return deleteQueue.poll();
    }
}
