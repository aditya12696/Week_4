import org.junit.jupiter.api.*;
import uppertolowerconverter.UpperToLowerConverter;

import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class UpperToLowerConverterTest {
    private static final String TEST_INPUT_FILE = "test_input.txt";
    private static final String TEST_OUTPUT_FILE = "test_output.txt";

    @BeforeEach
    void setUp() throws IOException {
        // Create a test input file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(TEST_INPUT_FILE))) {
            bw.write("HELLO WORLD!\nJAVA TESTING.\nFILE HANDLING.");
        }
    }

    @Test
    void testConvertFileToLowercase() {
        // Perform conversion
        boolean success = UpperToLowerConverter.convertFileToLowercase(TEST_INPUT_FILE, TEST_OUTPUT_FILE);
        assertTrue(success, "Conversion should be successful.");

        // Read and verify output file
        try (BufferedReader br = new BufferedReader(new FileReader(TEST_OUTPUT_FILE))) {
            assertEquals("hello world!", br.readLine());
            assertEquals("java testing.", br.readLine());
            assertEquals("file handling.", br.readLine());
        } catch (IOException e) {
            fail("Error reading output file: " + e.getMessage());
        }
    }

    @AfterEach
    void tearDown() {
        // Delete test files
        new File(TEST_INPUT_FILE).delete();
        new File(TEST_OUTPUT_FILE).delete();
    }
}
