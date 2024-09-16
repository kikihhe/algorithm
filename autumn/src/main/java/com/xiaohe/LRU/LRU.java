package com.xiaohe.LRU;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class LRU<K, V> {
    // 虚拟头节点
    public Node<K, V> head;
    public Node<K, V> tail;
    public HashMap<K, Node<K, V>> map = new HashMap<>();

    // 定时删除过期数据
    private ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1);

    // 存放过期时间的堆
    private PriorityQueue<Node<K, V>> priorityQueue = new PriorityQueue<>(Comparator.comparingLong(a -> a.expireTime));

    public LRU() {
        head = new Node<>();
        scheduledExecutorService.schedule(() -> {
            Node<K, V> node = priorityQueue.peek();
            if (node.expireTime < System.currentTimeMillis()) {
                remove(node.key);
            }
        }, 1, TimeUnit.SECONDS);
    }

    public void set(K k, V v, long timeout, TimeUnit timeUnit) {
        // 如果已经存在，刷新过期时间并移到最前面
        Node<K, V> node = map.get(k);
        if (node != null) {
            get(k);
        } else {
            node = new Node<>(k, v, timeout, timeUnit);
            insertTail(node);
            map.put(k, node);
            if (timeout != -1) {
                priorityQueue.add(node);
            }
        }
    }


    public V get(K k) {
        Node<K, V> node = map.get(k);
        if (node == null) {
            return null;
        }
        // 过期
        if (node.isExpired()) {
            remove(k);
            return null;
        }
        // 不过期
        remove(k);
        node.freshExpireTime();
        insertHead(node);
        return node.value;
    }

    public void insertTail(Node node) {
        node.prev = tail;
        tail.next = node;
        tail = node;
    }
    // 插入到链表头部
    public void insertHead(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next = node;
        node.next.prev = node;
    }

    public Node remove(K key) {
        Node<K, V> node = map.get(key);
        if (node == null) {
            return null;
        }
        map.remove(key);
        node.next.prev = node.prev;
        node.prev.next = node.next;

        node.prev = null;
        node.next = null;
        return node;
    }
}
