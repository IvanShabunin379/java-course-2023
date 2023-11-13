package edu.hw5;

import org.jetbrains.annotations.NotNull;

public final class Task4 {
    private Task4() {
    }

    public static boolean containsSpecialCharacter(@NotNull String password) {
        return password.matches(".*[~!@#$%^&*|].*");
    }
}
