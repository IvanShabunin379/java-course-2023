package edu.hw5.task3;

import java.time.LocalDate;
import java.util.Optional;

public class RelativeDateStrategy implements DateParsingStrategy {
    @Override
    public Optional<LocalDate> tryParse(String string) {
        return switch (string.toLowerCase()) {
            case "yesterday" -> Optional.of(LocalDate.now().minusDays(1));
            case "today" -> Optional.of(LocalDate.now());
            case "tomorrow" -> Optional.of(LocalDate.now().plusDays(1));
            default -> Optional.empty();
        };
    }
}
