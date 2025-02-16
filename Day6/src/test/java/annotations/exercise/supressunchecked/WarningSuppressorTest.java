package annotations.exercise.supressunchecked;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class WarningSuppressorTest {

    @Test
    @SuppressWarnings("unchecked")
    void testRawList() {
        ArrayList rawList = new ArrayList(); // No generics used
        rawList.add("Test String");
        rawList.add(42);

        assertEquals("Test String", rawList.get(0));
        assertEquals(42, rawList.get(1));
    }
}
