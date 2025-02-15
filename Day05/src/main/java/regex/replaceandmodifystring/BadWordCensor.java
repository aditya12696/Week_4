package regex.replaceandmodifystring;

import java.util.List;
import java.util.regex.Pattern;

public class BadWordCensor {
    public static String censorBadWords(String text, List<String> badWords) {
        for (String word : badWords) {
            String regex = "\\b" + Pattern.quote(word) + "\\b"; // Match whole words only
            text = text.replaceAll(regex, "****");
        }
        return text;
    }

    public static void main(String[] args) {
        String input = "This is a damn bad example with some stupid words.";
        List<String> badWords = List.of("damn", "stupid");

        String censoredText = censorBadWords(input, badWords);

        System.out.println("Censored Text:");
        System.out.println(censoredText);
    }
}
