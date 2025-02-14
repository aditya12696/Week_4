package uncheckedexceptionexample;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UncheckedExceptionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter numerator: ");
            int num = scanner.nextInt();

            System.out.print("Enter denominator: ");
            int denom = scanner.nextInt();

            int result = num / denom;
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed!");
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter valid numbers!");
        } finally {
            scanner.close();
        }
    }
}
