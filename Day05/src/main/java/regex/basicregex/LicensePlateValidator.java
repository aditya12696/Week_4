package regex.basicregex;

public class LicensePlateValidator {
    public static boolean isValidLicensePlate(String plate) {
        return plate.matches("^[A-Z]{2}\\d{4}$");
    }

    public static void main(String[] args) {
        String[] testPlates = {
                "AB1234", "A12345", "XY5678", "abc123",
                "12AB34", "ZZ9999", "A1B234", "AB12CD"
        };

        for (String plate : testPlates) {
            System.out.println("License Plate: " + plate + " → " +
                    (isValidLicensePlate(plate) ? "Valid" : "Invalid"));
        }
    }
}
