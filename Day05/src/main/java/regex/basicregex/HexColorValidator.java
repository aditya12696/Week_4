package regex.basicregex;

public class HexColorValidator {
    public static boolean isValidHexColor(String color) {
        return color.matches("^#[0-9A-Fa-f]{6}$");
    }

    public static void main(String[] args) {
        // Sample Test Cases
        String[] testColors = {
                "#FFA500", "#ff4500", "#123", "#00FF00",
                "#abcdef", "#A1B2C3", "#GHIJKL", "123456"
        };

        for (String color : testColors) {
            System.out.println("Hex Color: " + color + " → " +
                    (isValidHexColor(color) ? "Valid" : "Invalid"));
        }
    }
}
