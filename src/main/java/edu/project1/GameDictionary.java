package edu.project1;

import java.util.Random;
import org.jetbrains.annotations.NotNull;

public class GameDictionary implements Dictionary {
    static final String[] WORDS = {"hangman", "hello", "world", "exception", "dictionary"};
    private final Random rand = new Random();

    @Override
    public @NotNull String randomWord() {
        return WORDS[rand.nextInt(WORDS.length)];
    }
}
