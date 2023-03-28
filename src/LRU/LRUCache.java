package LRU;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-03-28 19:34
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    // 缓存数据大小
    private final int CACHE_SIZE;
    // 指定缓存大小
    public LRUCache(int cacheSize) {
        super((int)Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
        this.CACHE_SIZE = cacheSize;
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > CACHE_SIZE;
    }
    public static void main(String[] args) {
        LRUCache<Integer, Integer> cache = new LRUCache<>(10);
        for (int i = 0; i < 10; i++) {
            cache.put(i*10, i*100);
        }
        for (int i = 9; i >= 0; i--) {
            cache.get(i*10);
        }
        // 继续添加，由于缓存已经满了，会执行删除操作，从90开始删
        for (int i = 0; i < 10; i++) {
            cache.put(i+5, i+100);
        }

    }
}

