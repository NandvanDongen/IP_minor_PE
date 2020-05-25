package ip_minor.project.model.DTO;

import ip_minor.project.model.UserRole;
import ip_minor.project.model.dto.UserDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class UserDTOTest {
    @Test
    public void testSetUsername() {
        // setup
        UserDTO user = new UserDTO();

        // method to be tested
        user.setUsername("username");

        // checks
        assertNotNull(user.getUsername());
        assertEquals("username", user.getUsername());
    }

    @Test
    public void testSetRole() {
        // setup
        UserDTO user = new UserDTO();

        // method to be tested
        user.setRole(UserRole.USER);

        // checks
        assertNotNull(user.getRole());
        assertEquals(UserRole.USER, user.getRole());
    }
}
