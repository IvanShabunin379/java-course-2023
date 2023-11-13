package edu.hw5;

import org.jetbrains.annotations.NotNull;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class Task6 {
    private Task6() {
    }

    public static boolean isSubsequence(@NotNull String s, @NotNull String t) {
        if (t.isEmpty())
            return false;

        return Pattern.compile(s).matcher(t).find();
    }
}