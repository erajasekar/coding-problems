package com.erajasekar.async;

import com.erajasekar.zipkin.Loggable;
import com.google.common.flogger.FluentLogger;

public class LoggerTest implements Loggable {

    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    public static void main(String[] args) {
        logger.atInfo().log("Hello");
        logger.atSevere().withCause(new RuntimeException("Raja test")).log("Hello");
        System.out.println(new LoggerTest().getLogger());
    }
}
