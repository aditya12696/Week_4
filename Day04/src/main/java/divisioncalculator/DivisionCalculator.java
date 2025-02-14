package divisioncalculator;
import java.util.Scanner;

public class DivisionCalculator {
    public static int divide(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
            throw e;
        } finally {
            System.out.println("Operation completed");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter numerator: ");
        int num = scanner.nextInt();
        System.out.print("Enter denominator: ");
        int denom = scanner.nextInt();

        try {
            int result = divide(num, denom);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Exception handled.");
        }
    }
}
