package edu.project1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SessionTest {
    private Session session;

    @BeforeEach public void createSession() {
        session = new Session("hello", 3);
    }

    @Test
    public void whenGuessIsSuccessfulShouldReturnSuccessfulGuessState() {
        assertTrue(session.guess('h') instanceof GuessResult.SuccessfulGuess);
    }

    @Test
    public void whenGuessIsSuccessfulShouldOpenGuessedLetter() {
        assertThat(String.valueOf(session.guess('l').state())).isEqualTo("**ll*");
    }

    @Test
    public void whenGuessIsFailedShouldReturnFailedGuessState() {
        assertTrue(session.guess('a') instanceof GuessResult.FailedGuess);
    }

    @Test
    public void whenGuessIsFailedShouldNotChangeUserAnswer() {
        assertThat(String.valueOf(session.guess('a').state())).isEqualTo("*****");
    }

    @Test
    public void whenUserGuessedAllLettersShouldReturnWinState() {
        session.guess('h');
        session.guess('e');
        session.guess('l');
        assertTrue(session.guess('o') instanceof GuessResult.Win);
    }

    @Test
    public void whenAttemptsAreOverShouldReturnDefeatState() {
        session.guess('a');
        session.guess('b');
        assertTrue(session.guess('c') instanceof GuessResult.Defeat);
    }

    @Test
    public void giveUpShouldReturnDefeatState() {
        assertTrue(session.giveUp() instanceof GuessResult.Defeat);
    }
}
