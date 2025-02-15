package regex.replaceandmodifystring;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import regex.replaceandmodifystring.SpaceNormalizer;

class SpaceNormalizerTest {

    @Test
    void testNormalizeSpaces() {
        String input = "This    is  an   example    with  multiple   spaces.";
        String result = SpaceNormalizer.normalizeSpaces(input);

        assertEquals("This is an example with multiple spaces.", result);
    }

    @Test
    void testNoExtraSpaces() {
        String input = "This is normal text.";
        String result = SpaceNormalizer.normalizeSpaces(input);

        assertEquals("This is normal text.", result);
    }

    @Test
    void testLeadingAndTrailingSpaces() {
        String input = "   Trim   spaces    at   both ends   ";
        String result = SpaceNormalizer.normalizeSpaces(input);

        assertEquals("Trim spaces at both ends", result);
    }
}
