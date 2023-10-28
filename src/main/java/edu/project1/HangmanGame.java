package edu.project1;

public final class HangmanGame {
    private HangmanGame() {
    }

    @SuppressWarnings({"UncommentedMain", "RegexpSinglelineJava"})
    public static void main(String[] args) {
        try {
            ConsoleHangman hangman = new ConsoleHangman();
            hangman.run();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
