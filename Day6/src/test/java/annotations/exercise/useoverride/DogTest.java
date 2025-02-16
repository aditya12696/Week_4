package annotations.exercise.useoverride;

// DogTest.java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class DogTest {

    @Test
    void testMakeSound() {
        Dog dog = new Dog();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        dog.makeSound();

        System.setOut(System.out);
        assertEquals("Dog barks\n", outContent.toString());
    }
}
