package com.erajasekar;

import java.util.*;

class LongestSubstringKDistinct {
    public static int findLength(String str, int k) {

        int start = 0;
        int end = 0;
        int maxLength = 0;
        Map<Character, Integer> frequencies = new HashMap();

        for(end = 0; end < str.length(); end++) {

            char right = str.charAt(end);
            int freq = frequencies.getOrDefault(right, 0);

            frequencies.put(right, ++freq);

            System.out.println(frequencies + "[ " + start + " , " + end + " ]");
            if (frequencies.size() > k) {
                frequencies.remove(str.charAt(start));
                start++;
            }
            maxLength = end - start + 1;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("daraaci", 2)); // 4
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1)); // 2
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3)); // 5
    }
}
