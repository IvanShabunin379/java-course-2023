package edu.hw3.task4;

import java.util.NavigableMap;
import java.util.TreeMap;

@SuppressWarnings("MagicNumber")
public final class ArabicToRomanConverter {
    private static final NavigableMap<Integer, String> MATCHING_ARABIC_AND_ROMAN_NUMERALS = new TreeMap<>();

    static {
        MATCHING_ARABIC_AND_ROMAN_NUMERALS.put(1000, "M");
        MATCHING_ARABIC_AND_ROMAN_NUMERALS.put(900, "CM");
        MATCHING_ARABIC_AND_ROMAN_NUMERALS.put(500, "D");
        MATCHING_ARABIC_AND_ROMAN_NUMERALS.put(400, "CD");
        MATCHING_ARABIC_AND_ROMAN_NUMERALS.put(100, "C");
        MATCHING_ARABIC_AND_ROMAN_NUMERALS.put(90, "XC");
        MATCHING_ARABIC_AND_ROMAN_NUMERALS.put(50, "L");
        MATCHING_ARABIC_AND_ROMAN_NUMERALS.put(40, "XL");
        MATCHING_ARABIC_AND_ROMAN_NUMERALS.put(10, "X");
        MATCHING_ARABIC_AND_ROMAN_NUMERALS.put(9, "IX");
        MATCHING_ARABIC_AND_ROMAN_NUMERALS.put(5, "V");
        MATCHING_ARABIC_AND_ROMAN_NUMERALS.put(4, "IV");
        MATCHING_ARABIC_AND_ROMAN_NUMERALS.put(1, "I");
    }

    private ArabicToRomanConverter() {
    }

    public static String convertToRoman(int number) {
        if (number <= 0 || number >= 4000) {
            return null;
        }

        StringBuilder roman = new StringBuilder();

        int copyOfNumber = number;
        for (Integer arabicNumeral : MATCHING_ARABIC_AND_ROMAN_NUMERALS.descendingKeySet()) {
            while (copyOfNumber >= arabicNumeral) {
                roman.append(MATCHING_ARABIC_AND_ROMAN_NUMERALS.get(arabicNumeral));
                copyOfNumber -= arabicNumeral;
            }
        }

        return roman.toString();
    }
}
