package com.erajasekar.async;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExamples {

    public static void main(String[] args) {
        ConcurrentHashMap<String,Integer> cache = new ConcurrentHashMap<>();
        System.out.println(cache.computeIfAbsent("5" , (k -> 5) ));
        System.out.println(cache);
    }
}
