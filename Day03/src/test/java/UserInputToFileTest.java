import org.junit.jupiter.api.*;
import userinputtofile.UserInputToFile;

import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

class UserInputToFileTest {
    private static final String TEST_FILE = "test_user_data.txt";

    @BeforeEach
    void setUp() {
        // Ensure the test file is clean before each test
        new File(TEST_FILE).delete();
    }

    @Test
    void testUserInputFileWriting() {
        // Simulated user input
        String simulatedInput = "John Doe\n30\nPython\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream); // Redirect system input to simulated input

        // Redirect file writing to test file
        try {
            System.setOut(new PrintStream(new ByteArrayOutputStream())); // Suppress console output
            UserInputToFile.main(new String[]{}); // Run the program
        } finally {
            System.setIn(System.in); // Restore system input
            System.setOut(System.out); // Restore system output
        }

        // Check if file is created
        File file = new File("user_data.txt"); // Change to TEST_FILE if modifying original program
        assertTrue(file.exists(), "User data file should be created.");

        // Read the file and verify content
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            assertEquals("Name: John Doe", reader.readLine());
            assertEquals("Age: 30", reader.readLine());
            assertEquals("Favorite Language: Python", reader.readLine());
            assertEquals("------------------------------", reader.readLine());
        } catch (IOException e) {
            fail("Error reading test file: " + e.getMessage());
        }
    }

    @AfterEach
    void tearDown() {
        // Delete the test file after each test
        new File("user_data.txt").delete();
    }
}
