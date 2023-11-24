package edu.hw5.task4;

import org.jetbrains.annotations.NotNull;

public final class PasswordValidator {
    private PasswordValidator() {
    }

    public static boolean containsSpecialCharacter(@NotNull String password) {
        return password.matches(".*[~!@#$%^&*|].*");
    }
}
