package servie.impl;

import model.Cache;
import model.DoublyLinkedList;
import servie.DoublyLLService;
import servie.EvictionPolicy;

import java.util.HashMap;
import java.util.Map;

public class LruEvictionPolicy<T, V> implements EvictionPolicy<T,V> {
    private DoublyLLService<T> doublyLLService;

    private Map<T,DoublyLinkedList<T>> accessedMap;

    public LruEvictionPolicy() {
        this.doublyLLService = new DoublyLinkListSeriveImpl<>();
        accessedMap = new HashMap<>();
    }

    @Override
    public void evictCache(Cache<T, V> cache, int capacity, T key) {

        if (cache.getKeyMap().size() > capacity) {
            DoublyLinkedList<T> lastKey = doublyLLService.getLast();
            cache.getKeyMap().remove((T)lastKey.getKey());
            accessedMap.remove((T)lastKey.getKey());
            doublyLLService.remove(lastKey);
        }
        DoublyLinkedList<T> tDoublyLinkedList = new DoublyLinkedList<>(key);
        doublyLLService.add(tDoublyLinkedList);
        accessedMap.put(key, tDoublyLinkedList);
    }

    @Override
    public void updateAccessed(T key) {
        DoublyLinkedList<T> tDoublyLinkedList = accessedMap.get(key);
        doublyLLService.remove(tDoublyLinkedList);
        doublyLLService.add(tDoublyLinkedList);
    }
}
