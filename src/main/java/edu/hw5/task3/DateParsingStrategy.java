package edu.hw5.task3;

import java.time.LocalDate;
import java.util.Optional;

public interface DateParsingStrategy {
    Optional<LocalDate> tryParse(String string);
}

