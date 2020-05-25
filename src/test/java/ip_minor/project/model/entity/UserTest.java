package ip_minor.project.model.entity;

import ip_minor.project.model.UserRole;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserTest {

    @Test
    public void testSetUsername() {
        // setup
        User user = new User();

        // method to be tested
        user.setUsername("username");

        // checks
        assertNotNull(user.getUsername());
        assertEquals("username", user.getUsername());
    }

    @Test
    public void testSetPassword() {
        // setup
        User user = new User();

        // method to be tested
        user.setPassword("t");

        // checks
        assertNotNull(user.getPassword());
        assertEquals("t", user.getPassword());
    }

    @Test
    public void testSetRole() {
        // setup
        User user = new User();

        // method to be tested
        user.setRole(UserRole.USER);

        // checks
        assertNotNull(user.getRole());
        assertEquals(UserRole.USER, user.getRole());
    }
}
