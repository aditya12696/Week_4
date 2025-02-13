import filehandling.FileCopy;
import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class FileCopyTest {

    private static final String SOURCE_FILE = "test_source.txt";
    private static final String DESTINATION_FILE = "test_destination.txt";

    @BeforeEach
    void setUp() throws IOException {
        // Create and write sample content to source file
        try (FileWriter writer = new FileWriter(SOURCE_FILE)) {
            writer.write("Hello, this is a test file.\n");
            writer.write("It has multiple lines.\n");
            writer.write("JUnit will verify the copy process.");
        }
    }

    @Test
    void testFileCopySuccess() {
        FileCopy.main(new String[]{});

        // Check if destination file exists
        File destFile = new File(DESTINATION_FILE);
        assertTrue(destFile.exists(), "Destination file should be created.");

        // Compare file contents
        assertDoesNotThrow(() -> {
            assertEquals(readFile(SOURCE_FILE), readFile(DESTINATION_FILE), "File contents should be identical.");
        });
    }

    @Test
    void testSourceFileNotFound() {
        File nonExistentFile = new File("non_existent.txt");
        assertFalse(nonExistentFile.exists(), "Source file should not exist.");

        Exception exception = assertThrows(RuntimeException.class, () -> {
            FileCopy.main(new String[]{"non_existent.txt", DESTINATION_FILE});
        });

        assertTrue(exception.getMessage().contains("Source file does not exist"));
    }

    @AfterEach
    void tearDown() {
        new File(SOURCE_FILE).delete();
        new File(DESTINATION_FILE).delete();
    }

    private String readFile(String fileName) throws IOException {
        return new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(fileName)));
    }
}
