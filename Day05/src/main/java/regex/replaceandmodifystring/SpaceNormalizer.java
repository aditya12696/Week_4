package regex.replaceandmodifystring;

public class SpaceNormalizer {
    public static String normalizeSpaces(String text) {
        return text.replaceAll("\\s+", " ").trim();
    }

    public static void main(String[] args) {
        String input = "This    is  an   example    with  multiple   spaces.";
        String output = normalizeSpaces(input);

        System.out.println("Normalized Text:");
        System.out.println(output);
    }
}
