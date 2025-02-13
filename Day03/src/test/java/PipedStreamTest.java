import org.junit.jupiter.api.Test;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class PipedStreamTest {

    @Test
    void testPipedStreamCommunication() throws IOException {
        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream(pos);

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(pos));
             BufferedReader reader = new BufferedReader(new InputStreamReader(pis))) {

            // Write test message
            String testMessage = "JUnit Test Message\n";
            writer.write(testMessage);
            writer.flush();

            // Read and verify message
            String receivedMessage = reader.readLine();
            assertEquals("JUnit Test Message", receivedMessage);

        } catch (IOException e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}
