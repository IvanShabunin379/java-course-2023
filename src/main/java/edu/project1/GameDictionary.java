package edu.project1;

import org.jetbrains.annotations.NotNull;
import java.util.Random;

public class GameDictionary implements Dictionary {
    static final String[] WORDS = {"hangman", "hello", "world", "exception", "dictionary"};

    @Override
    public @NotNull String randomWord() {
        Random rand = new Random();
        return WORDS[rand.nextInt(WORDS.length)];
    }
}