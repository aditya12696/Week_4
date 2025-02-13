package imagebytearrayconverter;
import java.io.*;

public class ImageByteArrayConverter {
    public static void main(String[] args) {
        String sourceImage = "F:\\Local\\Week04\\Day03\\src\\main\\java\\imagebytearrayconverter\\original_image.jfif"; // Change to your image path
        String destinationImage = "F:\\Local\\Week04\\Day03\\src\\main\\java\\imagebytearrayconverter\\copied_image.jfif";

        // Convert image to byte array
        byte[] imageBytes = convertImageToByteArray(sourceImage);
        if (imageBytes != null) {
            System.out.println("Image successfully converted to byte array. Size: " + imageBytes.length + " bytes.");

            // Convert byte array back to image
            if (convertByteArrayToImage(imageBytes, destinationImage)) {
                System.out.println("Image successfully restored as " + destinationImage);
            } else {
                System.out.println("Failed to restore the image.");
            }
        } else {
            System.out.println("Failed to convert the image.");
        }
    }

    // Method to convert an image file to a byte array
    public static byte[] convertImageToByteArray(String imagePath) {
        try (FileInputStream fis = new FileInputStream(imagePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096]; // 4 KB buffer
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();

        } catch (IOException e) {
            System.out.println("Error converting image to byte array: " + e.getMessage());
            return null;
        }
    }

    // Method to convert a byte array back to an image file
    public static boolean convertByteArrayToImage(byte[] imageBytes, String outputPath) {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(outputPath)) {

            byte[] buffer = new byte[4096]; // 4 KB buffer
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            return true;

        } catch (IOException e) {
            System.out.println("Error converting byte array to image: " + e.getMessage());
            return false;
        }
    }
}
