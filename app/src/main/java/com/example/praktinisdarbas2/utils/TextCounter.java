package com.example.praktinisdarbas2.utils;

public class TextCounter {
    public static int getCharsCount(String inputPhrase) {
        return inputPhrase.length();
    }

    public static int getWordsCount(String inputPhrase) {
        String trimmedPhrase = inputPhrase.trim();
        if (trimmedPhrase.isEmpty()) {
            return 0;
        }
        return trimmedPhrase.split("\\s+").length;
    }
}

