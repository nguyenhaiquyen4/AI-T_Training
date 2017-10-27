package com.chapter10;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String... args) {
        ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();
        map.put("ThanhCong", 17000L);
        map.put("Kumho", 20000L);
        map.put("Mailinh", 19000L);
        map.put("PhuongTrang", 19500L);
        map.put("HungCuong", 18500L);
        Map.Entry<String, Long> ret = map.reduceEntries(5, (x, y) -> x.getValue() > y.getValue() ? x : y);
        System.out.println(ret.getKey());
    }
}
