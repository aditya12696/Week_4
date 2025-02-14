package nestedtrycatchexample;
import java.util.Scanner;

public class NestedTryCatchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = {10, 20, 30, 40, 50};

        System.out.print("Enter index: ");
        int index = scanner.nextInt();
        System.out.print("Enter divisor: ");
        int divisor = scanner.nextInt();

        try {
            try {
                int value = arr[index]; // May throw ArrayIndexOutOfBoundsException
                int result = value / divisor; // May throw ArithmeticException
                System.out.println("Result: " + result);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid array index!");
            }
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!");
        }
    }
}
