package pipedstreamexample;
import java.io.*;

public class PipedStreamExample {
    public static void main(String[] args) {
        try {
            // Create piped input and output streams
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            // Create and start writer and reader threads
            Thread writerThread = new Thread(new WriterTask(pos));
            Thread readerThread = new Thread(new ReaderTask(pis));

            writerThread.start();
            readerThread.start();

            // Wait for threads to complete
            writerThread.join();
            readerThread.join();

        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Writer Task (Writes data to PipedOutputStream)
    static class WriterTask implements Runnable {
        private final PipedOutputStream pos;

        public WriterTask(PipedOutputStream pos) {
            this.pos = pos;
        }

        @Override
        public void run() {
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(pos))) {
                String[] messages = {"Hello", "This is a piped stream", "Inter-thread communication", "End"};
                for (String message : messages) {
                    writer.write(message + "\n");
                    writer.flush(); // Ensure immediate write
                    System.out.println("Writer: " + message);
                    Thread.sleep(500); // Simulate processing time
                }
            } catch (IOException | InterruptedException e) {
                System.out.println("Writer Error: " + e.getMessage());
            }
        }
    }

    // Reader Task (Reads data from PipedInputStream)
    static class ReaderTask implements Runnable {
        private final PipedInputStream pis;

        public ReaderTask(PipedInputStream pis) {
            this.pis = pis;
        }

        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(pis))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("Reader: " + line);
                    Thread.sleep(700); // Simulate processing delay
                }
            } catch (IOException | InterruptedException e) {
                System.out.println("Reader Error: " + e.getMessage());
            }
        }
    }
}
