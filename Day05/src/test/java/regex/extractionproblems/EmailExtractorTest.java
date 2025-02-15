package regex.extractionproblems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import regex.extractionproblems.EmailExtractor;

import java.util.List;

class EmailExtractorTest {

    @Test
    void testExtractEmails() {
        String text = "Contact us at support@example.com and info@company.org";
        List<String> result = EmailExtractor.extractEmails(text);

        assertEquals(2, result.size());
        assertTrue(result.contains("support@example.com"));
        assertTrue(result.contains("info@company.org"));
    }

    @Test
    void testNoEmails() {
        String text = "This is a test message with no emails.";
        List<String> result = EmailExtractor.extractEmails(text);

        assertTrue(result.isEmpty());
    }

    @Test
    void testMultipleEmails() {
        String text = "Emails: user1@gmail.com, user.2@domain.net, contact@service.io";
        List<String> result = EmailExtractor.extractEmails(text);

        assertEquals(3, result.size());
        assertTrue(result.contains("user1@gmail.com"));
        assertTrue(result.contains("user.2@domain.net"));
        assertTrue(result.contains("contact@service.io"));
    }
}
