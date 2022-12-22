package com.coffeproject.Controllers;


import com.coffeproject.Models.User;
import com.coffeproject.Repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserRepository usersDao;

    private final PasswordEncoder passwordEncoder;


    public UserController(UserRepository usersDao, PasswordEncoder passwordEncoder) {
        this.usersDao = usersDao;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping("/register")
    public String showRegistration(Model model){
        model.addAttribute("user", new User());
        return "/registration";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        usersDao.save(user);
        return "redirect:/home";
    }



}
