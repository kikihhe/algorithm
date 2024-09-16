package com.xiaohe.LRU;

import java.util.concurrent.TimeUnit;

public class Node<K, V> {
    public K key;
    public V value;
    // 过期时间 millis
    public long expireTime;
    // corn
    public long timeout;

    public TimeUnit timeUnit;

    public Node next;
    public Node prev;

    public Node() {

    }
    public Node(K k, V v) {
        this(k ,v, -1);
    }

    public Node(K key, V value, long timeout) {
        this(key, value, timeout, TimeUnit.MILLISECONDS);
    }

    public Node(K key, V value, long timeout, TimeUnit timeUnit) {
        this.key = key;
        this.timeout = timeout;
        this.timeUnit = timeUnit;
        this.value = value;
        freshExpireTime();
    }

    /**
     * 刷新过期时间
     */
    public void freshExpireTime() {
        if (timeout != -1) {
            expireTime = System.currentTimeMillis() + TimeUnit.MILLISECONDS.convert(timeout, timeUnit);
        }
    }
    public boolean isExpired() {
        if (this.timeout == -1) {
            return false;
        }
        return expireTime < System.currentTimeMillis();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        if (hashCode() != obj.hashCode()) {
            return false;
        }
        return this.key.equals(((Node<?, ?>) obj).key) && this.value.equals(((Node<?, ?>) obj).value)
                && this.timeout == ((Node) obj).timeout
                && this.timeUnit.equals(((Node<?, ?>) obj).timeUnit);
    }
}
