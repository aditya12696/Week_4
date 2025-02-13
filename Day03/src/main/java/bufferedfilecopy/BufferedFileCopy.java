package bufferedfilecopy;
import java.io.*;

public class BufferedFileCopy {
    private static final int BUFFER_SIZE = 4096; // 4 KB

    public static void main(String[] args) {
        String sourceFile = "F:\\Local\\Week04\\Day03\\src\\main\\java\\bufferedfilecopy\\largefile.txt"; // Example 100MB file
        String destBuffered = "copy_buffered.txt";
        String destUnbuffered = "copy_unbuffered.txt";

        // Copy using Buffered Streams
        long bufferedTime = copyFileBuffered(sourceFile, destBuffered);
        System.out.println("Buffered Copy Time: " + bufferedTime + " ns");

        // Copy using Unbuffered Streams
        long unbufferedTime = copyFileUnbuffered(sourceFile, destUnbuffered);
        System.out.println("Unbuffered Copy Time: " + unbufferedTime + " ns");

        // Performance Comparison
        System.out.println("\nBuffered copy is " + (double) unbufferedTime / bufferedTime + " times faster.");
    }

    // Copy file using Buffered Streams
    public static long copyFileBuffered(String source, String destination) {
        long startTime = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Error copying file (Buffered): " + e.getMessage());
        }
        return System.nanoTime() - startTime;
    }

    // Copy file using Unbuffered Streams
    public static long copyFileUnbuffered(String source, String destination) {
        long startTime = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Error copying file (Unbuffered): " + e.getMessage());
        }
        return System.nanoTime() - startTime;
    }
}
