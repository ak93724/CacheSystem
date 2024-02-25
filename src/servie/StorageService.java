package servie;

public interface StorageService<T, V> {
    void add(T key, V data);

    V get(T key);
}
