package edu.project1;

import java.util.Arrays;
import java.util.HashSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameDictionaryTest {
    private static final int COUNT_OF_TEST_REPETITIONS = 500;
    private GameDictionary gameDictionary;

    @BeforeEach
    public void setUp() {
        gameDictionary = new GameDictionary();
    }

    @RepeatedTest(COUNT_OF_TEST_REPETITIONS)
    public void shouldReturnWordFromWordsArray() {
        String word = gameDictionary.randomWord();
        assertTrue(Arrays.asList(GameDictionary.WORDS).contains(word));
    }

    @Test
    public void shouldNotReturnFixedWord() {
        HashSet<String> words = new HashSet<>();
        for (int i = 0; i < 5; ++i) {
            words.add(gameDictionary.randomWord());
        }
        assertTrue(words.size() > 1);
    }
}
