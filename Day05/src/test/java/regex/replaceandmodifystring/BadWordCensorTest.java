package regex.replaceandmodifystring;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import regex.replaceandmodifystring.BadWordCensor;

import java.util.List;

class BadWordCensorTest {

    @Test
    void testCensorBadWords() {
        String input = "This is a damn bad example with some stupid words.";
        List<String> badWords = List.of("damn", "stupid");

        String result = BadWordCensor.censorBadWords(input, badWords);

        assertEquals("This is a **** bad example with some **** words.", result);
    }

    @Test
    void testNoBadWords() {
        String input = "This is a clean sentence.";
        List<String> badWords = List.of("damn", "stupid");

        String result = BadWordCensor.censorBadWords(input, badWords);

        assertEquals("This is a clean sentence.", result); // No changes
    }

    @Test
    void testBadWordsInDifferentCases() {
        String input = "This is a Damn bad example with some Stupid words.";
        List<String> badWords = List.of("damn", "stupid");

        String result = BadWordCensor.censorBadWords(input, badWords);

        assertEquals("This is a Damn bad example with some Stupid words.", result); // Case-sensitive replacement
    }
}
