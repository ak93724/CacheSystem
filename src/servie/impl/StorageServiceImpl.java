package servie.impl;

import model.Cache;
import servie.EvictionPolicy;
import servie.StorageService;

public class StorageServiceImpl<T, V> implements StorageService<T, V> {

    private Cache<T, V> cache = new Cache<>();
    private int capacity;

    private EvictionPolicy evictionPolicy;

    public StorageServiceImpl() {
        evictionPolicy = new LruEvictionPolicy();
        capacity = 5;
    }
    public StorageServiceImpl(int capacity, EvictionPolicy<T, V> evictionPolicy) {
        this.capacity = capacity;
        this.evictionPolicy = evictionPolicy;
    }

    @Override
    public synchronized void add(T key, V data) {
        cache.getKeyMap().put(key, data);
        evictionPolicy.evictCache(cache, capacity, key);
    }

    @Override
    public V get(T key) {
        V data = null;
        if (cache.getKeyMap().containsKey(key)) {
            data = cache.getKeyMap().get(key);
            evictionPolicy.updateAccessed(key);
        }
        return data;
    }
}
