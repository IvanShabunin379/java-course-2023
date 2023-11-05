package edu.hw3.task1;

public final class AtbashCipher {
    private AtbashCipher() {
    }

    public static String atbash(String str) {
        StringBuilder result = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (!isEnglishLetter(c)) {
                result.append(c);
            } else {
                char mirroredChar = Character.isUpperCase(c) ? (char) ('Z' - c + 'A') : (char) ('z' - c + 'a');
                result.append(mirroredChar);
            }
        }

        return result.toString();
    }

    private static boolean isEnglishLetter(char c) {
        return (c >= 'a' && c <= 'z') || ((c >= 'A' && c <= 'Z'));
    }
}
