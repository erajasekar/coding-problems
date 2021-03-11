package com.erajasekar.zipkin;

import java.lang.invoke.MethodHandles;

public interface Loggable {

    default String getLogger(){
        return MethodHandles.lookup().lookupClass().toString();
    }
}
