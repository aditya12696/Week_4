import imagebytearrayconverter.ImageByteArrayConverter;
import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;
import userinputtofile.UserInputToFile;
class ImageByteArrayConverterTest {
    private static final String TEST_IMAGE = "test_image.jpg"; // Use a small test image
    private static final String OUTPUT_IMAGE = "output_test_image.jpg";

    @BeforeEach
    void setUp() {
        // Ensure old test files are removed before each test
        new File(OUTPUT_IMAGE).delete();
    }

    @Test
    void testImageConversion() {
        // Convert test image to byte array
        byte[] imageBytes = ImageByteArrayConverter.convertImageToByteArray(TEST_IMAGE);
        assertNotNull(imageBytes, "Byte array should not be null.");
        assertTrue(imageBytes.length > 0, "Byte array should have data.");

        // Convert byte array back to image
        boolean success = ImageByteArrayConverter.convertByteArrayToImage(imageBytes, OUTPUT_IMAGE);
        assertTrue(success, "Image should be successfully restored.");

        // Check if the output file exists
        File outputFile = new File(OUTPUT_IMAGE);
        assertTrue(outputFile.exists(), "Output image file should exist.");
    }

    @AfterEach
    void tearDown() {
        // Clean up the generated test file
        new File(OUTPUT_IMAGE).delete();
    }
}
