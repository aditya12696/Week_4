package reflections.basiclevel;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import reflections.basiclevel.personreflection.Person;

import java.lang.reflect.Field;

class PersonReflectionTest {

    @Test
    void testModifyPrivateField() {
        try {
            Person person = new Person(25);


            Field ageField = Person.class.getDeclaredField("age");
            ageField.setAccessible(true);

            ageField.set(person, 30);

            assertEquals(30, person.getAge(), "The age field should be updated to 30.");

        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}
