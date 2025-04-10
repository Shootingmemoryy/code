import sun.misc.LRUCache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Shootingmemory
 * @create 2025-03-05-13:37
 */
    //LRU缓存机制
public class Main {
    class LRUCache extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }

    public static void main(String[] args) {

    }
}