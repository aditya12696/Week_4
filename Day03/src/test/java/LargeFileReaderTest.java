import org.junit.jupiter.api.Test;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class LargeFileReaderTest {

    @Test
    void testFilterErrorLines() throws IOException {
        // Sample test file content
        String testData = "INFO - System started\nERROR - Network failure\nINFO - Task completed\n";
        File tempFile = File.createTempFile("test_log", ".txt");

        // Write test data to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            writer.write(testData);
        }

        // Read file and check filtered output
        try (BufferedReader reader = new BufferedReader(new FileReader(tempFile))) {
            String line;
            boolean foundError = false;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    foundError = true;
                    assertEquals("ERROR - Network failure", line);
                }
            }
            assertTrue(foundError, "No error line found");
        }

        // Cleanup
        tempFile.delete();
    }
}
