package com.erajasekar.async;

import java.net.URI;
import java.net.URL;
import java.util.function.Consumer;

public class ConsumerExceptionHandling {

    public static void main(String[] args) throws Exception {

        URI url = new URI("https://na44.stmfa.stm.salesforce.com:9443/");

        System.out.println(url.getPort());
        System.out.println(url.getScheme() + url.getHost() + url.getPath());
        url.toString();

        try {
            wrapConsumer( s -> doWork(s));
        }catch (Exception e){
            System.out.println("Handle -> " + e.getMessage());
        }

    }

    private static void doWork(String param){
        throw new RuntimeException("Failing " + param);
    }

    private static void wrapConsumer(Consumer<String> consumer){
        consumer.accept("test");
    }
}
