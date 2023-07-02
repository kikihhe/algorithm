package 队列的最大值;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class MaxQueue {

    private Queue<Integer> queue1;
    private Deque<Integer> queue2;
    

    public MaxQueue() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public int max_value() {
        if (queue2.size() == 0) return -1;
        return queue2.getLast();
    }
    
    public void push_back(int value) {
        // 直接向queue1中放入数据
        queue1.add(value);
        // 向queue2中放入数据，将尾巴上比value小的数据删除
        while (queue2.size() > 0 && value > queue2.getFirst()) {
            queue2.pollFirst();
        }
        queue2.push(value);
    }
    
    public int pop_front() {
        if (queue1.isEmpty()) return -1;
        // 直接将queue1中的数据弹出
        int result = queue1.poll();
        if (result == queue2.getLast()) {
            queue2.pollLast();
        }
        return result;

    }

    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.pop_front());
        maxQueue.push_back(15);
        System.out.println(maxQueue.max_value());
        maxQueue.push_back(9);
        System.out.println(maxQueue.max_value());



    }
}
