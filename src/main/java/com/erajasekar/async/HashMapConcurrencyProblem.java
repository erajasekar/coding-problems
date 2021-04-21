package com.erajasekar.async;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.*;

public class HashMapConcurrencyProblem {

    private static Map<String,Long> cache = new HashMap<>();

    public static void main(String[] args) {

        class Producer implements Callable<String> {

            private Random rand = new Random();

            @Override
            public String call() throws Exception {
                int i = 0;
                while (true){

                    long val = rand.nextInt(1_000);
                    String key = val  + Thread.currentThread().getName();
                   // System.out.println("Putting key : " + key + " : Thread : " );
                    cache.put(key, val);
                    if (cache.get(key) == null) {
                        System.out.println(i++ + " : Key " + key + " has not been put in the map" + " : Thread : " + Thread.currentThread().getName());
                    }
                }

            }
        }

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        try {
            for (int i = 0 ; i < 6 ; i++){
                executorService.submit(new Producer());
            }
        }finally {
            executorService.shutdown();
        }
    }
}
