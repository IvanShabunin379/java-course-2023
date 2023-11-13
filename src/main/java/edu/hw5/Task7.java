package edu.hw5;

import org.jetbrains.annotations.NotNull;

public final class Task7 {
    private Task7() {
    }

    public static boolean containsAtLeastThreeCharsAndThirdCharIsZero(@NotNull String str) {
        return str.matches("^[01]{2}0[01]*$");
    }

    public static boolean startsAndEndsWithSameChar(@NotNull String str) {
        return str.matches("^([01])([01]*\\1$)?");
    }

    public static boolean isNoShorterThanOneAndNotLongerThanThree(@NotNull String str) {
        return str.matches("^[01]{1,3}$");
    }
}
