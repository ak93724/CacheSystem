package model;

import java.util.HashMap;
import java.util.Map;

public class Cache<T, V> {

    private Map<T, V> keyMap;

    public Map<T, V> getKeyMap() {
        return keyMap;
    }

    public void setKeyMap(Map<T, V> keyMap) {
        this.keyMap = keyMap;
    }

    public Cache() {
        keyMap = new HashMap<>();
    }
}
