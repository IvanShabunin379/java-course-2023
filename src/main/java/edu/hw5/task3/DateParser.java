package edu.hw5.task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class DateParser {
    List<DateParsingStrategy> strategies;

    public DateParser() {
        buildChain();
    }

    private void buildChain() {
        strategies = Arrays.asList(
            new YearMonthDayStrategy(DateTimeFormatter.ofPattern("yyyy-MM-dd")),
            new YearMonthDayStrategy(DateTimeFormatter.ofPattern("yyyy-MM-d")),
            new YearMonthDayStrategy(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
            new YearMonthDayStrategy(DateTimeFormatter.ofPattern("d/M/yyyy")),
            new YearMonthDayStrategy(DateTimeFormatter.ofPattern("d/M/yy")),
            new RelativeDateStrategy(),
            new DaysAgoStrategy()
        );
    }

    public Optional<LocalDate> parseDate(String string) {
        for (DateParsingStrategy strategy : strategies) {
            Optional<LocalDate> date = strategy.tryParse(string);
            if (date.isPresent()) {
                return date;
            }
        }
        return Optional.empty();
    }
}
