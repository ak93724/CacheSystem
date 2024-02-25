package servie.impl;

import servie.CacheController;
import servie.EvictionPolicy;
import servie.StorageService;

public class CacheControllerService<T,V> implements CacheController<T, V> {

    private static CacheController cacheController;
    private StorageService<T, V> storageService;

    private CacheControllerService(int capacity, EvictionPolicy<T, V> evictionPolicy) {
        storageService = new StorageServiceImpl<>(capacity, evictionPolicy);
    }

    private CacheControllerService() {
        storageService = new StorageServiceImpl<>();
    }

    public static CacheController getInstance() {
        if(cacheController == null) {
            cacheController = new CacheControllerService<>();
        }

        return cacheController;
    }

    public static CacheController getInstance(int capacity, EvictionPolicy evictionPolicy) {
        return new CacheControllerService<>(capacity, evictionPolicy);
    }


    @Override
    public void add(T key, V value) throws Exception {
        if(key == null || value == null) {
           throw new Exception("Invalid Values provided");
        }

        storageService.add(key, value);
    }

    @Override
    public void get(T key) throws Exception {

        if (key == null) {
            throw new Exception("Invalid Key provided");
        }
        V value = storageService.get(key);
        if(value == null) {
            System.out.println("Key not found : "+key);
        }
        else {
            System.out.println("Value : " + value);
        }
    }

}
