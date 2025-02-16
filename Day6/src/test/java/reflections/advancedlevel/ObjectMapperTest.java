package reflections.advancedlevel;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import reflections.advancedlevel.objectmapper.ObjectMapper;
import reflections.advancedlevel.objectmapper.Person;

import java.util.HashMap;
import java.util.Map;

class ObjectMapperTest {

    @Test
    void testToObject() {

        Map<String, Object> personData = new HashMap<>();
        personData.put("name", "Anand");
        personData.put("age", 25);
        personData.put("city", "Bhopal");


        Person person = ObjectMapper.toObject(Person.class, personData);


        assertEquals("Anand", person.getName());
        assertEquals(25, person.getAge());
        assertEquals("Bhopal", person.getCity());
    }
}
