package annotations.practiceproblems.advanced.jsonfield;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class JsonSerializerTest {

    @Test
    void testSerialization() {
        User user = new User("Alice", 30, "Ignore this");
        String json = JsonSerializer.serialize(user);
        assertTrue(json.contains("\"user_name\":\"Alice\""));
        assertTrue(json.contains("\"user_age\":30"));
        assertFalse(json.contains("ignoredField"));
    }
}
