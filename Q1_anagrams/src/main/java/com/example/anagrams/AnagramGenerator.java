package com.example.anagrams;

import java.util.*;

/**
 * Generates all anagrams for a given string of distinct alphabetic characters.
 * Time complexity: O(n!)
 * Space complexity: O(n!)
 */
public final class AnagramGenerator {

    private AnagramGenerator() {}

    public static List<String> generate(String input) {
        if (input == null || input.isEmpty()) return Collections.emptyList();

        for (char c : input.toCharArray()) {
            if (!Character.isLetter(c)) return Collections.emptyList();
        }

        List<String> result = new ArrayList<>();
        permute("", input, result);
        return result;
    }

    private static void permute(String prefix, String remaining, List<String> result) {
        if (remaining.isEmpty()) {
            result.add(prefix);
            return;
        }
        for (int i = 0; i < remaining.length(); i++) {
            permute(prefix + remaining.charAt(i),
                    remaining.substring(0, i) + remaining.substring(i + 1),
                    result);
        }
    }
}
