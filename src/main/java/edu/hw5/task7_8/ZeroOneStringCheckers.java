package edu.hw5.task7_8;

import org.jetbrains.annotations.NotNull;

public final class ZeroOneStringCheckers {
    private ZeroOneStringCheckers() {
    }

    // -------- Задание 7. --------

    public static boolean containsAtLeastThreeCharsAndThirdCharIsZero(@NotNull String str) {
        return str.matches("^[01]{2}0[01]*$");
    }

    public static boolean startsAndEndsWithSameChar(@NotNull String str) {
        return str.matches("^([01])([01]*\\1$)?");
    }

    public static boolean isNoShorterThanOneAndNotLongerThanThree(@NotNull String str) {
        return str.matches("^[01]{1,3}$");
    }

    // ------- Задание 8. --------

    public static boolean hasOddLength(@NotNull String str) {
        return str.matches("^[01]([01]{2})*$");
    }

    public static boolean startsWithZeroAndHasOddLenOrStartsWithOneAndHasEvenLength(@NotNull String str) {
        return str.matches("^0([01]{2})*$|^1[01]([01]{2})*$");
    }

    public static boolean countOfZerosIsMultipleOfThree(@NotNull String str) {
        return str.matches("^(1*01*01*01*)*$");
    }

    public static boolean isNot11AndNot111(@NotNull String str) {
        return str.matches("^(?!11$|111$)[01]*$");
    }

    public static boolean eachOddCharIsOne(@NotNull String str) {
        return str.matches("^1(01|11)*$");
    }
}
