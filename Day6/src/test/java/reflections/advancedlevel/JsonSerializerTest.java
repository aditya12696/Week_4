package reflections.advancedlevel;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import reflections.advancedlevel.jsonrepresentation.JsonSerializer;
import reflections.advancedlevel.jsonrepresentation.Person;

class JsonSerializerTest {

    @Test
    void testToJson() {
        Person person = new Person("Anand", 22, false);
        String expectedJson = "{\"name\": \"Anand\", \"age\": 22, \"isEmployed\": false}";

        assertEquals(expectedJson, JsonSerializer.toJson(person));
    }
}
