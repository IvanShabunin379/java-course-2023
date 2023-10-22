package edu.hw1;

import org.jetbrains.annotations.NotNull;

public final class Task1 {
    private Task1() {
    }

    public static int minutesToSeconds(@NotNull String time) {
        String[] parts = time.split(":");

        if ((parts.length != 2) || (parts[0].length() < 2) || (parts[1].length() < 2)) {
            return -1;
        }

        final int SECONDS_IN_MINUTE = 60;
        try {
            int minutes = Integer.parseInt(parts[0]);
            int seconds = Integer.parseInt(parts[1]);

            if ((minutes < 0) || (seconds < 0) || (seconds >= SECONDS_IN_MINUTE)) {
                return -1;
            }

            return minutes * SECONDS_IN_MINUTE + seconds;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
