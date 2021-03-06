package ip_minor.project.model.service;

import ip_minor.project.model.UserRole;
import ip_minor.project.model.dto.CreateUserDTO;
import ip_minor.project.model.dto.UserDTO;
import ip_minor.project.model.entity.User;
import ip_minor.project.model.repository.UserRepo;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo repository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepo repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User does not exist");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Collections.singletonList(new SimpleGrantedAuthority(user.getRole().name())));
    }

    @Override
    public UserDTO createUser(CreateUserDTO userDTO) throws Exception {
        for(User user : repository.findAll()){
            if(user.getUsername().equals(userDTO.getUsername())){
                throw new Exception("Username in use");
            }
        }
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setRole(userDTO.getUsername().endsWith("admin") ? UserRole.ADMIN : UserRole.USER);
        user = repository.save(user);
        return convert(user);
    }

    protected UserDTO convert(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setRole(user.getRole());
        return dto;
    }
}
