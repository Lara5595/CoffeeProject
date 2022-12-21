package com.coffeproject.Controllers;

import com.coffeproject.Models.Coffee;
import com.coffeproject.Repositories.CoffeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CoffeeController {

    private final CoffeeRepository coffeeDao;

    public CoffeeController(CoffeeRepository coffeeDao) {
        this.coffeeDao = coffeeDao;
    }

    @GetMapping("/")
    public String splashPage() {
        return "splashPage";
    }


//    This takes you to create coffee page
    @GetMapping("/create")
    public String CreateACoffee(Model model){
        model.addAttribute("coffee", new Coffee());
        return "createCoffee";
    }

//    This post the coffee
    @PostMapping("/create")
    public String postACoffee(@ModelAttribute Coffee coffee){
        coffeeDao.save(coffee);
        return "redirect:/";
    }


}
