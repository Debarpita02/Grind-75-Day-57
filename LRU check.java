import java.util.*;

class LRUCache {
    private final int capacity;
    private final Map<Integer, Integer> cache;
    private final LinkedList<Integer> lruOrder;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.lruOrder = new LinkedList<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key))
            return -1;

        // Move the accessed key to the end of the LRU list
        lruOrder.remove(Integer.valueOf(key));
        lruOrder.addLast(key);

        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.size() >= capacity) {
            int lruKey = lruOrder.poll();
            cache.remove(lruKey);
        }

        // Add the new key-value pair
        cache.put(key, value);
        lruOrder.remove(Integer.valueOf(key));
        lruOrder.addLast(key);
    }
}
