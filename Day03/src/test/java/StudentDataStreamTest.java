import org.junit.jupiter.api.*;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentDataStreamTest {
    private static final String TEST_FILE = "test_student_data.bin";

    @BeforeEach
    void setUp() throws IOException {
        // Create sample data for testing
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(TEST_FILE))) {
            dos.writeInt(202);
            dos.writeUTF("Test User");
            dos.writeDouble(9.2);
        }
    }

    @Test
    void testWriteAndReadStudentData() {
        // Read data from the test file
        try (DataInputStream dis = new DataInputStream(new FileInputStream(TEST_FILE))) {
            assertEquals(202, dis.readInt());
            assertEquals("Test User", dis.readUTF());
            assertEquals(9.2, dis.readDouble(), 0.01);
        } catch (IOException e) {
            fail("Error reading test file: " + e.getMessage());
        }
    }

    @AfterEach
    void tearDown() {
        // Delete the test file after testing
        new File(TEST_FILE).delete();
    }
}
