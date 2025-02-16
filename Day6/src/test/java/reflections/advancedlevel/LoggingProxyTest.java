package reflections.advancedlevel;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import reflections.advancedlevel.loggingproxy.Greeting;
import reflections.advancedlevel.loggingproxy.GreetingImpl;
import reflections.advancedlevel.loggingproxy.LoggingProxy;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class LoggingProxyTest {

    @Test
    void testLoggingProxy() {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Greeting greeting = new GreetingImpl();
        Greeting proxy = LoggingProxy.createProxy(greeting, Greeting.class);

        String result = proxy.sayHello("Anand");


        System.setOut(System.out);

        assertEquals("Hello, Anand!", result);
        assertTrue(outputStream.toString().contains("Executing method: sayHello"));
    }
}
