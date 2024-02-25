package servie;

import model.Cache;

public interface EvictionPolicy<T, V> {

    void evictCache(Cache<T, V> cache, int capacity, T key);

    void updateAccessed(T key);
}
