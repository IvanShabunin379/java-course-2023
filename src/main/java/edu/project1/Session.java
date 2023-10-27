package edu.project1;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

public class Session {
    private final String answer;
    private final char[] userAnswer;
    private final int maxAttempts;
    private int attempts;

    public Session(String answer, int maxAttempts) {
        this.answer = answer;
        userAnswer = new char[answer.length()];
        Arrays.fill(userAnswer, '*');

        this.maxAttempts = maxAttempts;
        attempts = 0;
    }

    public String getAnswer() {
        return answer;
    }

    @SuppressWarnings("MultipleStringLiterals")
    @NotNull GuessResult guess(char guess) {
        boolean isSuccesessfulGuess = false;

        for (int i = 0; i < answer.length(); ++i) {
            if (answer.charAt(i) == guess) {
                userAnswer[i] = answer.charAt(i);
                isSuccesessfulGuess = true;
            }
        }

        if (!isSuccesessfulGuess) {
            ++attempts;
        }

        if (String.valueOf(userAnswer).equals(answer)) {
            return new GuessResult.Win(userAnswer, attempts, maxAttempts, "Hit!");
        } else if (attempts == maxAttempts) {
            return new GuessResult.Defeat(
                userAnswer,
                attempts,
                maxAttempts,
                "Missed, mistake " + attempts + " out of " + maxAttempts + "."
            );
        } else if (isSuccesessfulGuess) {
            return new GuessResult.SuccessfulGuess(userAnswer, attempts, maxAttempts, "Hit!");
        } else {
            return new GuessResult.FailedGuess(userAnswer, attempts, maxAttempts,
                "Missed, mistake " + attempts + " out of " + maxAttempts + "."
            );
        }
    }

    @NotNull GuessResult giveUp() {
        return new GuessResult.Defeat(userAnswer, attempts, maxAttempts, "You gave up! The word was: " + answer + ".");
    }
}
