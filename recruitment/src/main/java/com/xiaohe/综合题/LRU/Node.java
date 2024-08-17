package com.xiaohe.综合题.LRU;

public class Node {
    public String key;
    public String value;
    public long expire = -1;

    public Node prev;
    public Node next;

    public Node() {
    }

    public Node(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public Node(long expire, String key, String value) {
        this.expire = expire;
        this.key = key;
        this.value = value;
    }
}
