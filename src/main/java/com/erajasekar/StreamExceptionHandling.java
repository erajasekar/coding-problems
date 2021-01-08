package com.erajasekar;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.stream.Stream;
import java.time.DayOfWeek;

public class StreamExceptionHandling {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    /**
     * Converts given date string in format "MM/dd/yyyy" to LocalDate.
     */
    private static LocalDate parseDate(String dateString) {
        return LocalDate.from(formatter.parse(dateString));
    }
    public static void main(String args[]) {
        Stream.of("12/31/2014",
                "01-01-2015",
                "12/31/2015",
                "not a date",
                "01/01/2016")
                .map(StreamExceptionHandling::parseDate)
                .map(DayOfWeek::from)
                .forEach(System.out::println);
    }
}
