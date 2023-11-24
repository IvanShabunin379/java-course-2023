package edu.hw5.task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class YearMonthDayStrategy implements DateParsingStrategy {
    private final DateTimeFormatter formatter;

    YearMonthDayStrategy(DateTimeFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public Optional<LocalDate> tryParse(String string) {
        try {
            LocalDate date = LocalDate.parse(string, formatter);
            return Optional.of(date);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
