package com.olsh;

/**
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
 *
 * For example,
 * 123 -> "One Hundred Twenty Three"
 * 12345 -> "Twelve Thousand Three Hundred Forty Five"
 * 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 */

import java.util.HashMap;
import java.util.Map;

class IntegerToEnglishWord {
    static Map<Integer, String[]> dictionary = new HashMap<>();

    public static String numberToWords(int num) {
        if (num == 0) return "Zero";
        StringBuilder res = new StringBuilder();
        dictionary.put(0, new String[]{"", "", "Ten"});
        dictionary.put(1, new String[]{"One", "", "Eleven"});
        dictionary.put(2, new String[]{"Two", "Twenty", "Twelve"});
        dictionary.put(3, new String[]{"Three", "Thirty", "Thirteen"});
        dictionary.put(4, new String[]{"Four", "Forty", "Fourteen"});
        dictionary.put(5, new String[]{"Five", "Fifty", "Fifteen"});
        dictionary.put(6, new String[]{"Six", "Sixty", "Sixteen"});
        dictionary.put(7, new String[]{"Seven", "Seventy", "Seventeen"});
        dictionary.put(8, new String[]{"Eight", "Eighty", "Eighteen"});
        dictionary.put(9, new String[]{"Nine", "Ninety", "Nineteen"});
        int[] threeDigits = new int[]{(num / 1_000_000_000) % 1_000, (num / 1_000_000) % 1_000, (num / 1_000) % 1_000, num % 1_000};
        String[] helpingWords = new String[]{"Billion", "Million", "Thousand", ""};
        writeCurrentState(res, threeDigits[0], helpingWords[0], "N/A");
        for (int i = 1; i < 4; i++) {
            writeCurrentState(res, threeDigits[i], helpingWords[i], helpingWords[i - 1]);
        }
        return res.toString().replaceAll("\\s{2,}", " ").trim();
    }

    private static void writeCurrentState(StringBuilder res, int digit, String helpingWord, String wordBefore) {
        if (digit == 0) {
            return;
        } else {
            int index = 0;
            if (digit / 100 != 0) res.append(dictionary.get(digit / 100)[0]).append(" Hundred ");
            if (digit / 10 % 10 == 1) res.append(dictionary.get(digit % 10)[2]);
            else
                res.append(dictionary.get(digit / 10 % 10)[1]).append(" ").append(dictionary.get(digit % 10)[0]).append(" ");
            res.append(" ").append(helpingWord).append(" ");
        }
    }

    public static void main(String[] args) {
        System.out.println(numberToWords(1_234_567_718));
        System.out.println(numberToWords(1_100_000_000));
        System.out.println(numberToWords(100_000_000));
        System.out.println(numberToWords(10_000_000));
        System.out.println(numberToWords(1_000_000));
        System.out.println(numberToWords(100_000));
        System.out.println(numberToWords(10_000));
        System.out.println(numberToWords(1_000));
        System.out.println(numberToWords(100));

    }
}