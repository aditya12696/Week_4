package regex.extractionproblems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import regex.extractionproblems.LinkExtractor;

import java.util.List;

class LinkExtractorTest {

    @Test
    void testExtractValidLinks() {
        String text = "Visit https://www.google.com and http://example.org for more info.";
        List<String> result = LinkExtractor.extractLinks(text);

        assertEquals(2, result.size());
        assertTrue(result.contains("https://www.google.com"));
        assertTrue(result.contains("http://example.org"));
    }

    @Test
    void testNoLinksInText() {
        String text = "This text has no links, just plain words.";
        List<String> result = LinkExtractor.extractLinks(text);

        assertTrue(result.isEmpty());
    }

    @Test
    void testExtractMultipleLinks() {
        String text = "Check https://openai.com, http://github.com, and https://stackoverflow.com/questions/123.";
        List<String> result = LinkExtractor.extractLinks(text);

        assertEquals(3, result.size());
        assertTrue(result.contains("https://openai.com"));
        assertTrue(result.contains("http://github.com"));
        assertTrue(result.contains("https://stackoverflow.com/questions/123"));
    }
}
