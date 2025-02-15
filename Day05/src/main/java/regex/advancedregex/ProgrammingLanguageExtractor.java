package regex.advancedregex;

import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class ProgrammingLanguageExtractor {
    private static final List<String> PROGRAMMING_LANGUAGES = List.of(
            "Java", "Python", "JavaScript", "C", "C++", "C#", "Go", "Ruby", "Swift", "Kotlin",
            "PHP", "Rust", "TypeScript", "Perl", "R", "Scala", "Dart", "Objective-C", "Haskell", "Lua"
    );

    public static List<String> extractLanguages(String text) {
        List<String> extractedLanguages = new ArrayList<>();
        for (String lang : PROGRAMMING_LANGUAGES) {
            String regex = "\\b" + Pattern.quote(lang) + "\\b";
            if (Pattern.compile(regex).matcher(text).find()) {
                extractedLanguages.add(lang);
            }
        }
        return extractedLanguages;
    }

    public static void main(String[] args) {
        String input = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        List<String> languages = extractLanguages(input);

        System.out.println("Extracted Languages: " + String.join(", ", languages));
    }
}
