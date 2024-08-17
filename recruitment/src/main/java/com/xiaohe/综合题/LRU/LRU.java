package com.xiaohe.综合题.LRU;

import java.util.HashMap;
import java.util.Map;

public class LRU {
    private Map<String, Node> cache = new HashMap<>();
    private int size;
    private int capacity;
    private Node head;
    private Node tail;

    public LRU(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public String get(String key) {
        Node node = cache.get(key);
        if (node == null) {
            return null;
        }
        moveTOHead(node);
        return node.value;
    }

    public Node put(String key, String value) {
        Node node = cache.get(key);
        if (node == null) {
            node = new Node(key, value);
            cache.put(key, node);
            addTOHead(node);
            size++;
            if (size > capacity) {
                Node nowTail = removeTail();
                size--;
                cache.remove(nowTail.key);
            }
        } else {
            node.value = value;
            moveTOHead(node);
        }
        return node;
    }
    /**
     * 将一个节点放到头部
     * @param node
     */
    public void moveTOHead(Node node) {
        removeNode(node);
        addTOHead(node);
    }

    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addTOHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    /**
     * 删除链表的尾节点
     */
    public Node removeTail() {
       Node node = tail.prev;
       removeNode(node);
       return node;
    }
}
