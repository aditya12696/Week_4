package annotations.practiceproblems.advanced.roleallowed;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class RoleAccessControlTest {

    @Test
    void testAdminAccess() {
        User admin = new User("ADMIN");
        AdminService service = new AdminService();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        service.invokeMethodIfAllowed(admin, "performAdminTask");
        assertTrue(outputStream.toString().contains("Admin task executed successfully!"));
    }

    @Test
    void testUserDeniedAccessToAdminTask() {
        User user = new User("USER");
        AdminService service = new AdminService();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        service.invokeMethodIfAllowed(user, "performAdminTask");
        assertTrue(outputStream.toString().contains("Access Denied! Only ADMIN can execute this."));
    }
}
