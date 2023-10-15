package edu.hw1;

public class Task5_SpecialPalindrome {
    public static boolean isPalindromeDescendant(int number) {
        if (isPalindrome(number)) {
            return true;
        }

        int currentDescendant = calculateDescendant(number);
        while (currentDescendant > 9) {
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

        while (number != 0) {
            result = result * 10 + number % 10;
            number /= 10;
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
