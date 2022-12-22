package com.coffeproject.Controllers;

import com.coffeproject.Models.Coffee;
import com.coffeproject.Models.User;
import com.coffeproject.Repositories.CoffeeRepository;
import com.coffeproject.Repositories.UserRepository;
import com.coffeproject.Services.Utils;
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

    private final UserRepository userDao;


    public CoffeeController(CoffeeRepository coffeeDao, UserRepository userDao) {
        this.coffeeDao = coffeeDao;
        this.userDao = userDao;
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
        User user = Utils.currentUser();
        if (user.getId() == 0){
            return "redirect:/login";
        }
        coffee.setUser(user);
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


    @PostMapping("/{id}/edit")
    public String editCoffee(@ModelAttribute Coffee coffee){
        coffeeDao.save(coffee);
        return "redirect:/home";
    }


//    This is for delete

    @GetMapping("/{id}/delete")
    public String deleteCoffee(Coffee coffee){
        coffeeDao.delete(coffee);
        return "redirect:/home";
    }



    //    profile
    @GetMapping("/profile")
    public String profile(Model model){
        User user = userDao.findById(Utils.currentUserProfile());
        List<Coffee> coffees = user.getUsersCoffee();
        model.addAttribute("coffees", coffees);
        return "profile";
    }

}
