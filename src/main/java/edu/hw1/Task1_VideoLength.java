package edu.hw1;

import org.jetbrains.annotations.NotNull;

public class Task1_VideoLength {
    public static int minutesToSeconds(@NotNull String time) {
        String[] parts = time.split(":");

        if (parts.length != 2 || parts[0].length() < 2 || parts[1].length() < 2) {
            return -1;
        }

        try {
            int minutes = Integer.parseInt(parts[0]);
            int seconds = Integer.parseInt(parts[1]);

            if (minutes < 0 || seconds < 0 || seconds >= 60) {
                return -1;
            }

            return minutes * 60 + seconds;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
