import org.junit.jupiter.api.Test;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class TryWithResourcesTest {

    @Test
    void testFileReadSuccess() throws IOException {
        String fileName = "info.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Hello, world!");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String firstLine = reader.readLine();
            assertEquals("Hello, world!", firstLine);
        }
    }

    @Test
    void testFileNotFound() {
        Exception exception = assertThrows(IOException.class, () -> {
            try (BufferedReader reader = new BufferedReader(new FileReader("non_existent.txt"))) {
                reader.readLine();
            }
        });

        assertEquals(FileNotFoundException.class, exception.getClass());
    }
}
