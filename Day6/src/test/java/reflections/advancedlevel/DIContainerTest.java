package reflections.advancedlevel;
import org.junit.jupiter.api.Test;
import reflections.advancedlevel.dependencyinjection.Client;
import reflections.advancedlevel.dependencyinjection.DIContainer;
import reflections.advancedlevel.dependencyinjection.ServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class DIContainerTest {

    @Test
    void testDependencyInjection() throws Exception {
        // Create a DI container
        DIContainer container = new DIContainer();

        // Register ServiceImpl as an implementation of Service
        container.register(ServiceImpl.class);

        // Create a Client instance
        Client client = new Client();

        // Inject dependencies into the Client instance
        container.injectDependencies(client);

        // Check if the dependency was injected
        assertNotNull(client.service, "Service should be injected");

        // Check if the injected service is of the correct type
        assertTrue(client.service instanceof ServiceImpl, "Injected service should be of type ServiceImpl");

        // Capture output to verify execution
        assertDoesNotThrow(() -> client.run(), "Service execution should not throw exceptions");
    }
}
