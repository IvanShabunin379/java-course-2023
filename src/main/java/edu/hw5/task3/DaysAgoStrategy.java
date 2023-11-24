package edu.hw5.task3;

import java.time.LocalDate;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DaysAgoStrategy implements DateParsingStrategy {
    private static final Pattern DAYS_AGO_PATTERN = Pattern.compile("^(\\d+) (day|days) ago$");

    @Override
    public Optional<LocalDate> tryParse(String string) {
        Matcher matcher = DAYS_AGO_PATTERN.matcher(string);

        try {
            if (matcher.find()) {
                int days = Integer.parseInt(matcher.group(1));
                return Optional.of(LocalDate.now().minusDays(days));
            }
        } catch (Exception e) {
            return Optional.empty();
        }

        return Optional.empty();
    }
}
