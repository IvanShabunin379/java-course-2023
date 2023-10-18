package edu.hw1;

public final class Task5 {
    private Task5() {
    }

    public static boolean isPalindromeDescendant(int number) {
        if (isPalindrome(number)) {
            return true;
        }

        final int MAX_DIGIT = 9;
        int currentDescendant = calculateDescendant(number);
        while (currentDescendant > MAX_DIGIT) {
            if (isPalindrome(currentDescendant)) {
                return true;
            }
            currentDescendant = calculateDescendant(currentDescendant);
        }

        return false;

    }

    private static boolean isPalindrome(int number) {
        if (number < 0) {
            return false;
        }

        return (number == reverse(number));
    }

    private static int reverse(int number) {
        int result = 0;
        int copyOfNumber = number;

        final int RADIX = 10;
        while (copyOfNumber != 0) {
            result = result * RADIX + copyOfNumber % RADIX;
            copyOfNumber /= RADIX;
        }

        return result;
    }

    private static int calculateDescendant(int number) {
        String numStr = Integer.toString(number);
        StringBuilder descendant = new StringBuilder();

        for (int i = 0; i < numStr.length() - 1; i += 2) {
            int digit1 = numStr.charAt(i) - '0';
            int digit2 = numStr.charAt(i + 1) - '0';
            int sum = digit1 + digit2;
            descendant.append(sum);
        }

        return Integer.parseInt(descendant.toString());
    }
}
