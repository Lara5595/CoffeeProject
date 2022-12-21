package com.coffeproject.Controllers;

import com.coffeproject.Models.Coffee;
import com.coffeproject.Repositories.CoffeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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


//    HomePage
    @GetMapping("/home")
    public String homePage(Model model){
        List<Coffee> coffees = coffeeDao.findAll();
        model.addAttribute("coffees", coffees);
        return "homePage";
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
        return "redirect:/home";
    }


//    This takes you to the edit page

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable long id){
        Coffee coffee = coffeeDao.findById(id);
        model.addAttribute("coffee", coffee);
        return "/editCoffee";
    }




}
