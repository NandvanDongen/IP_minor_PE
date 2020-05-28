package ip_minor.project.model.service;

import ip_minor.project.model.UserRole;
import ip_minor.project.model.dto.CreateUserDTO;
import ip_minor.project.model.dto.UserDTO;
import ip_minor.project.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private UserServiceImpl userService;

    @Test
    public void testCreateUser() {
        // setup
        CreateUserDTO createUserDTO = new CreateUserDTO();
        createUserDTO.setUsername("gebruiker");
        createUserDTO.setPassword("pass");

        // method to be tested
        try {
            userService.createUser(createUserDTO);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        // checks
        assertNotNull(userService.loadUserByUsername("gebruiker"));
        UserDetails user = userService.loadUserByUsername("gebruiker");
        assertEquals("gebruiker", user.getUsername());
    }

    @Test
    public void testCreateUserWithUserNameTaken() {
        // setup
        String error1 = null;
        String error2 = null;
        CreateUserDTO createUserDTO = new CreateUserDTO();
        createUserDTO.setUsername("user");
        createUserDTO.setPassword("pass");
        CreateUserDTO userDTO = new CreateUserDTO();
        userDTO.setUsername("user");
        userDTO.setPassword("pass");
        try {
            userService.createUser(createUserDTO);
        } catch (Exception e) {
            error1 = e.getMessage();
        }
        // method to be tested
        try {
            userService.createUser(userDTO);
        } catch (Exception e) {
            error2 = e.getMessage();
        }

        // checks
        assertNull(error1);
        assertNotNull(error2);
        assertEquals(error2, "Username in use");
    }

    @Test
    public void testLoadUserByName() {
        // setup
        CreateUserDTO createUserDTO = new CreateUserDTO();
        createUserDTO.setUsername("utilisateur");
        createUserDTO.setPassword("pass");
        try {
            userService.createUser(createUserDTO);
        } catch (Exception e) {
        }

        // method to be tested
        UserDetails user = userService.loadUserByUsername("utilisateur");

        // checks
        assertNotNull(user);
        assertEquals("utilisateur", user.getUsername());
    }

    @Test
    public void testLoadUserByNameFails() {
        // setup

        // method to be tested
        try {
            userService.loadUserByUsername("utilisateur");
        }
        // checks
        catch (Exception e){
            assertEquals("User does not exist", e.getMessage());
        }
    }

    @Test
    public void testConvert() {
        // setup
        User user = new User();
        user.setUsername("benutzer");
        user.setPassword("pass");
        user.setRole(UserRole.USER);

        // method to be tested
        UserDTO userDTO = userService.convert(user);

        // checks
        assertNotNull(userDTO);
        assertEquals("benutzer", user.getUsername());
        assertEquals("pass", user.getPassword());
        assertEquals(UserRole.USER, user.getRole());
    }


}
