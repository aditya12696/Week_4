package regex.advancedregex;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import regex.advancedregex.ProgrammingLanguageExtractor;

import java.util.List;

class ProgrammingLanguageExtractorTest {

    @Test
    void testExtractLanguages() {
        String input = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        List<String> expected = List.of("Java", "Python", "JavaScript", "Go");
        assertEquals(expected, ProgrammingLanguageExtractor.extractLanguages(input));
    }

    @Test
    void testNoProgrammingLanguages() {
        String input = "I enjoy reading books and listening to music.";
        List<String> expected = List.of();
        assertEquals(expected, ProgrammingLanguageExtractor.extractLanguages(input));
    }

    @Test
    void testMixedCaseLanguages() {
        String input = "I have experience in java, PYTHON, and JavaScript.";
        List<String> expected = List.of("JavaScript"); // Case-sensitive match
        assertEquals(expected, ProgrammingLanguageExtractor.extractLanguages(input));
    }

    @Test
    void testProgrammingLanguagesWithPunctuation() {
        String input = "Rust, Swift, and C# are quite interesting!";
        List<String> expected = List.of("Rust", "Swift", "C#");
        assertEquals(expected, ProgrammingLanguageExtractor.extractLanguages(input));
    }
}
