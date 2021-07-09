package com.erajasekar.async;

import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateTest {

    public static void main(String[] args) {
        int i = validate(5, (v) -> v.equals(5), "fail");
        System.out.println(i);
    }

    private doWork()

    private static <T> T validate(T v, Predicate<T> p, String msg){
        if (p.test(v)){
            return v;
        }
        throw new RuntimeException(msg);
    }
}
