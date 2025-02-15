package regex.advancedregex;

import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class RepeatingWordsFinder {
    public static Set<String> findRepeatingWords(String text) {
        Map<String, Integer> wordCount = new HashMap<>();
        Pattern pattern = Pattern.compile("\\b\\w+\\b"); // Match words
        Matcher matcher = pattern.matcher(text.toLowerCase()); // Convert to lowercase for case insensitivity

        while (matcher.find()) {
            String word = matcher.group();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        return wordCount.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1) // Find words that appear more than once
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        String input = "This is is a repeated repeated word test.";
        Set<String> repeatingWords = findRepeatingWords(input);

        System.out.println("Repeating Words: " + String.join(", ", repeatingWords));
    }
}

