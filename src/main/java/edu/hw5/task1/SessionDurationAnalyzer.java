package edu.hw5.task1;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public final class SessionDurationAnalyzer {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");

    private static final String INVALID_INPUT_STRING_MSG = "One or more input strings are invalid.";
    private static final String INVALID_DATE_MSG = "One or more input contain invalid date.";
    private static final String END_DATE_IS_BEFORE_START_DATE_MSG =
        "One or more sessions have end date is before start date.";

    private SessionDurationAnalyzer() {
    }

    public static Duration calculateAverageSessionDuration(@NotNull List<String> sessions) {
        if (sessions.isEmpty()) {
            return Duration.ZERO;
        }

        Duration sumOfSessionDurations = Duration.ZERO;

        for (String session : sessions) {
            String[] timeStamps = session.split(" - ");
            if (timeStamps.length != 2) {
                throw new IllegalArgumentException(INVALID_INPUT_STRING_MSG);
            }

            LocalDateTime sessionStart;
            LocalDateTime sessionEnd;
            try {
                sessionStart = LocalDateTime.parse(timeStamps[0], FORMATTER);
                sessionEnd = LocalDateTime.parse(timeStamps[1], FORMATTER);
            } catch (DateTimeParseException dtp) {
                throw new IllegalArgumentException(INVALID_DATE_MSG);
            }

            if (sessionEnd.isBefore(sessionStart)) {
                throw new IllegalArgumentException(END_DATE_IS_BEFORE_START_DATE_MSG);
            }

            sumOfSessionDurations = sumOfSessionDurations.plus(Duration.between(sessionStart, sessionEnd));
        }

        return sumOfSessionDurations.dividedBy(sessions.size());
    }
}


