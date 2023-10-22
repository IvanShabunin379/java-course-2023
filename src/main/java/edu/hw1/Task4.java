package edu.hw1;

import org.jetbrains.annotations.NotNull;

public final class Task4 {
    private Task4() {
    }

    public static @NotNull String fixString(@NotNull String broken) {
        if (broken.length() < 2) {
            return broken;
        }

        StringBuilder fixed = new StringBuilder(broken);

        for (int i = 0; i < fixed.length() - 1; i += 2) {
            char tmp = fixed.charAt(i);
            fixed.setCharAt(i, fixed.charAt(i + 1));
            fixed.setCharAt(i + 1, tmp);
        }

        return fixed.toString();
    }
}
