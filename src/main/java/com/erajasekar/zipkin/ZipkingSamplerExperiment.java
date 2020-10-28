package com.erajasekar.zipkin;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ZipkingSamplerExperiment {

    private static final float SAMPLE_RATE = 0.1f;

    private static Sampler bs = BoundarySampler.create(SAMPLE_RATE);
    private static Sampler cs = CountingSampler.create(SAMPLE_RATE);


    public static void main(String[] args) {
       List<Long> input = new Random().longs(25)
                        .boxed()
                        .collect(Collectors.toList());

       int countSampled = 0, boundarySampled = 0;
       for(long i : input) {

           boolean isBoundary = bs.isSampled(i);
           boolean isCount = cs.isSampled(i);
           if (isBoundary){
               boundarySampled++;
           }
           if (isCount){
               countSampled++;
           }
           System.out.println(i + " -> " + isCount +  " : " + isBoundary);
        //   System.out.println("----------------------");
       }

        System.out.println(" Summary CountSampled : " + countSampled + " Boundary Sampled : "  + boundarySampled);
    }


}
