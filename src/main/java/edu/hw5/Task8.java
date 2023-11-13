package edu.hw5;

import org.jetbrains.annotations.NotNull;

public final class Task8 {
    private Task8() {
    }

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
