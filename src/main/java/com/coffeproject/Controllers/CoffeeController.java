package com.coffeproject.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CoffeeController {

    @GetMapping("/")
    public String splashPage() {
        return "splashPage";
    }

}
