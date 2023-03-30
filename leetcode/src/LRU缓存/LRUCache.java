package LRU缓存;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int CACHE_SIZE = 0;
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > CACHE_SIZE;
    }

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.CACHE_SIZE = capacity;
    }
    
    public int get(int key) {
        if (containsKey(key)) {
            return super.get(key);
        } else {
            return -1;
        }

    }
    
    public void put(int key, int value) {
        super.put(key, value);
    }

}

