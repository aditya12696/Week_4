package bufferedfilecopy;

import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class BufferedFileCopyTest {
    private static final String TEST_SOURCE_FILE = "test_largefile.txt";
    private static final String TEST_DEST_BUFFERED = "test_copy_buffered.txt";
    private static final String TEST_DEST_UNBUFFERED = "test_copy_unbuffered.txt";
    private static final int TEST_FILE_SIZE_MB = 10; // 10 MB Test File

    @BeforeEach
    void setUp() throws IOException {
        // Create a test file with random data
        try (FileOutputStream fos = new FileOutputStream(TEST_SOURCE_FILE)) {
            byte[] data = new byte[1024 * 1024]; // 1MB buffer
            for (int i = 0; i < TEST_FILE_SIZE_MB; i++) {
                fos.write(data);
            }
        }
    }

    @Test
    void testBufferedCopy() {
        long timeTaken = BufferedFileCopy.copyFileBuffered(TEST_SOURCE_FILE, TEST_DEST_BUFFERED);
        assertTrue(new File(TEST_DEST_BUFFERED).exists(), "Buffered copy file should exist.");
        assertDoesNotThrow(() -> assertEquals(new File(TEST_SOURCE_FILE).length(), new File(TEST_DEST_BUFFERED).length(), "Buffered file copy should have the same size."));
        System.out.println("Buffered Copy Time: " + timeTaken + " ns");
    }

    @Test
    void testUnbufferedCopy() {
        long timeTaken = BufferedFileCopy.copyFileUnbuffered(TEST_SOURCE_FILE, TEST_DEST_UNBUFFERED);
        assertTrue(new File(TEST_DEST_UNBUFFERED).exists(), "Unbuffered copy file should exist.");
        assertDoesNotThrow(() -> assertEquals(new File(TEST_SOURCE_FILE).length(), new File(TEST_DEST_UNBUFFERED).length(), "Unbuffered file copy should have the same size."));
        System.out.println("Unbuffered Copy Time: " + timeTaken + " ns");
    }

    @AfterEach
    void tearDown() {
        new File(TEST_SOURCE_FILE).delete();
        new File(TEST_DEST_BUFFERED).delete();
        new File(TEST_DEST_UNBUFFERED).delete();
    }
}
