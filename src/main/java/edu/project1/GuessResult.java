package edu.project1;

import org.jetbrains.annotations.NotNull;

public sealed interface GuessResult {
    char[] state();

    int attempt();

    int maxAttempts();

    @NotNull String message();

    @SuppressWarnings("RegexpSinglelineJava")
    default void printMessageAndState() {
        System.out.println(message());
        System.out.println();
        System.out.println("The word: " + String.valueOf(state()));
    }

    record Defeat(char[] state, int attempt, int maxAttempts, String message) implements GuessResult {
    }

    record Win(char[] state, int attempt, int maxAttempts, String message) implements GuessResult {
    }

    record SuccessfulGuess(char[] state, int attempt, int maxAttempts, String message) implements GuessResult {
    }

    record FailedGuess(char[] state, int attempt, int maxAttempts, String message) implements GuessResult {
    }
}
