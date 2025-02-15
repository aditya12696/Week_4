package regex.extractionproblems;

import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;

public class CapitalizedWordExtractor {
    public static List<String> extractCapitalizedWords(String text) {
        List<String> capitalizedWords = new ArrayList<>();
        String regex = "\\b[A-Z][a-z]*\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            capitalizedWords.add(matcher.group());
        }
        return capitalizedWords;
    }

    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        List<String> words = extractCapitalizedWords(text);

        System.out.println("Extracted Capitalized Words:");
        System.out.println(words);
    }
}

