package leetcode;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * LeetCode #146
 */
public class LRUCache {

    private final LinkedHashMap<Integer, Integer> cache;
    private final int maxSize;

    public LRUCache(int capacity) {
        cache = new LinkedHashMap<>(capacity, 0.75f, true);
        maxSize = capacity;
    }

    public int get(int key) {
        Integer element = cache.get(key);

        if (element == null) return -1;

        return element;
    }

    public void put(int key, int value) {
        Integer existed = this.get(key);
        if (existed != -1) {
            cache.put(key, value);
            return;
        }

        if (cache.size() >= maxSize) {
            Iterator<Integer> it = cache.keySet().iterator();
            it.next();
            it.remove();
        }

        cache.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
