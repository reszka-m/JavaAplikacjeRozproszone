package com.company;

public class Gloski {
    public static String shiftConsonants(String text, int shift) {
        char[] chars = text.toCharArray();
        int n = chars.length;
        char[] shifted = new char[n];
        for (int i = 0; i < n; i++) {
            char c = chars[i];
            if (isConsonant(c)) {
                int j = (i + shift) % n;
                shifted[j] = c;
            } else {
                shifted[i] = c;
            }
        }
        return new String(shifted);
    }

    private static boolean isConsonant(char c) {
        return (c >= 'a' && c <= 'z' && !isVowel(c)) || (c >= 'A' && c <= 'Z' && !isVowel(c));
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
