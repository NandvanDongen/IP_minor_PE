package ip_minor.project.controller;

import ip_minor.project.model.dto.CreateUserDTO;
import ip_minor.project.model.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLoginForm(Model model) {
        String error = null;
        model.addAttribute("usedname", error);
        return "signinform";
    }

    @GetMapping("/signup")
    public String getCreateUser(Model model) {
        model.addAttribute("user", new CreateUserDTO());
        return "signupform";
    }

    @PostMapping("/signup")
    public String postCreateUser(@ModelAttribute("user")@Valid CreateUserDTO user, BindingResult bindingResult, Model model) {
        String error = null;
        if (bindingResult.hasErrors()) {
            model.addAttribute("usedname", error);
            return "signupform";
        }
        try{
            userService.createUser(user);
            model.addAttribute("usedname", error);
            return "redirect:/login";
        }catch (Exception e){
            error = e.getMessage();
            model.addAttribute("usedname", error);
            return "signupform";
        }
    }
}

