package ip_minor.project.model.DTO;

import ip_minor.project.model.dto.CreateUserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CreateUserDTOTest {

    @Test
    public void testSetUsername() {
        // setup
        CreateUserDTO user = new CreateUserDTO();

        // method to be tested
        user.setUsername("username");

        // checks
        assertNotNull(user.getUsername());
        assertEquals("username", user.getUsername());
    }

    @Test
    public void testSetPassword() {
        // setup
        CreateUserDTO user = new CreateUserDTO();

        // method to be tested
        user.setPassword("t");

        // checks
        assertNotNull(user.getPassword());
        assertEquals("t", user.getPassword());
    }
}
