package ip_minor.project.model.service;

import ip_minor.project.model.dto.CreateUserDTO;
import ip_minor.project.model.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDTO createUser(CreateUserDTO userDTO) throws Exception;
}
