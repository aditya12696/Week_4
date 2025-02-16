package annotations.exercise.usedeprecated;

// LegacyAPITest.java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class LegacyAPITest {

    @Test
    void testNewFeature() {
        LegacyAPI api = new LegacyAPI();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        api.newFeature();

        System.setOut(System.out);
        assertEquals("New feature: Use this method instead.\n", outContent.toString());
    }

    @Test
    @SuppressWarnings("deprecation") // Suppress warning for testing purpose
    void testOldFeature() {
        LegacyAPI api = new LegacyAPI();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        api.oldFeature();

        System.setOut(System.out);
        assertEquals("Old feature: This method is deprecated.\n", outContent.toString());
    }
}
