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
        // 三个参数
        // 1. 初始容量: 创建的容器的初始容量，这里指定为 cacheSize / 0.75
        // 2. 负载因子: 数量达到 size*负载因子 时触发扩容.
        // 3. 排序模式: true代表按照访问顺序排序，最近访问的在头部，最老访问的在尾部
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
        for (int i = 0; i < 10; i++) {
            cache.put(i+5, i+100);
        }

    }
}
