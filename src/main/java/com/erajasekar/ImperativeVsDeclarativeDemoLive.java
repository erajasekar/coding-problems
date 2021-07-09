package com.erajasekar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ImperativeVsDeclarativeDemoLive {

    private static void wordsToCommaSeparatedString(){

        //Convert words with more than 3 letters to comma separated string
        List<String> words = Arrays.asList("one", "two", "three", "four", "five");
        StringBuilder sentence = new StringBuilder();

        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            if (word.length() > 3) {
                sentence.append(word).append(",");
            }
        }

    }

    private static void wordsToCommaSeparatedString2(){

        //Convert words with more than 3 letters to comma separated string
        List<String> words = Arrays.asList("one", "two", "three", "four", "five");

        words.stream()
          .filter(w -> w.length() > 3)
          .collect(Collectors.joining(","));

    }
    public static void main(String[] args) {
        wordsToCommaSeparatedString();
        wordsToCommaSeparatedString2();

        //SCRT Examples

        //ChatbotRequestContextVariablesFactory
        //ChatbotBrokerState : https://git.soma.salesforce.com/service-cloud-realtime/scrt2-ia-chatbot-service/commit/6049cf5372bb9a66e0a3ce80e20d95e59bb4a533#diff-b47694dba0887134b2beb0e14c59d5db
    }
}
