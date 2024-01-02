package 操作系统课设;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-12-30 14:04
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
