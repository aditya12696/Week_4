package reflections.intermediatelevel;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import reflections.intermediatelevel.modifystaticfield.Configuration;

import java.lang.reflect.Field;

class ModifyStaticFieldTest {

    @Test
    void testModifyStaticField() throws NoSuchFieldException, IllegalAccessException {
        // Get the class object
        Class<Configuration> configClass = Configuration.class;

        // Get the private static field API_KEY
        Field apiKeyField = configClass.getDeclaredField("API_KEY");

        // Make it accessible
        apiKeyField.setAccessible(true);

        // Modify the static field value
        apiKeyField.set(null, "TEST_KEY");

        // Validate the updated value
        assertEquals("TEST_KEY", Configuration.getApiKey(), "API_KEY should be updated to TEST_KEY");
    }
}
