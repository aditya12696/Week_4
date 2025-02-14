import org.junit.jupiter.api.Test;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class CheckedExceptionTest {

    @Test
    void testFileNotFound() {
        String fileName = "non_existent_file.txt";
        Exception exception = assertThrows(IOException.class, () -> {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                while (reader.readLine() != null) {}
            }
        });

        assertEquals(FileNotFoundException.class, exception.getClass());
    }

    @Test
    void testFileReadSuccess() throws IOException {
        String fileName = "data.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Hello, world!");
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            assertEquals("Hello, world!", line);
        }
    }
}
