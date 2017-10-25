package com.chapter7;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cache<K,V> extends LinkedHashMap<K,V> {
    private int max_size;

    public Cache(int max_size) {
        super();
        this.max_size = max_size;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        if (super.size() > this.max_size) {
            return true;
        }
        return false;
    }
}
