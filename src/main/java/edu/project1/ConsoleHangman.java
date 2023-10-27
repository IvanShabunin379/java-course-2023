package edu.project1;

import java.util.Scanner;

public class ConsoleHangman {
    private static final String INCORRECT_LENGTH_MSG =
        "\"Hangman\" cannot be started because the hidden word has an incorrect length (< 2)!";

    @SuppressWarnings("RegexpSinglelineJava")
    public void run() {
        Dictionary dictionary = new GameDictionary();
        String answer = dictionary.randomWord();
        if (answer.length() < 2) {
            throw new IllegalStateException(INCORRECT_LENGTH_MSG);
        }

        final int MAX_ATTEMPTS = 6;
        Session session = new Session(answer, MAX_ATTEMPTS);

        System.out.println("Welcome to Hangman!");
        System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess the word.");
        System.out.println("Let's get started!");

        boolean gameOver = false;

        while (!gameOver) {
            System.out.println("Guess a letter (or enter '0' to give up):");
            char guess = getLetterFromUser();
            if (guess == '0') {
                System.out.println(session.giveUp().message());
                return;
            }

            GuessResult guessResult = tryGuess(session, guess);
            printState(guessResult);
            System.out.println();

            gameOver = (guessResult instanceof GuessResult.Win) || (guessResult instanceof GuessResult.Defeat);
            if (gameOver) {
                String gameOverMessage = (guessResult instanceof GuessResult.Win) ? "You win!"
                    : "You lost! The word was: " + session.getAnswer();
                System.out.println(gameOverMessage);
            }
        }
    }

    @SuppressWarnings("RegexpSinglelineJava")
    private char getLetterFromUser() {
        Scanner keyboard = new Scanner(System.in);
        String input;

        input = keyboard.next();
        while (input.length() > 1 || (!Character.isLetter(input.charAt(0)) && input.charAt(0) != '0')) {
            System.out.println("You entered not a letter! Enter a letter (or enter '0' to give up):");
            input = keyboard.next();
        }

        return input.toLowerCase().charAt(0);
    }

    private GuessResult tryGuess(Session session, char guess) {
        return session.guess(guess);
    }

    @SuppressWarnings("RegexpSinglelineJava")
    private void printState(GuessResult guessResult) {
        System.out.println(guessResult.message());
        System.out.println();
        System.out.println("The word: " + String.valueOf(guessResult.state()));
    }
}
