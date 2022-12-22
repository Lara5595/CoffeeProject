package com.coffeproject.Controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class AuthenticationController {
    @GetMapping("/login")
    public String loginForm(){
        return "/login";
    }

}
