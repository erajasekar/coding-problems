package com.erajasekar.async;

import com.erajasekar.zipkin.Loggable;

public class LoggerTest implements Loggable {

    public static void main(String[] args) {
        Flogger flogger;
        System.out.println(new LoggerTest().getLogger());
    }
}
