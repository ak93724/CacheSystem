package servie;

public interface CacheController<T, V> {

    void add(T key, V value) throws Exception;
    void get(T key) throws Exception;
}
