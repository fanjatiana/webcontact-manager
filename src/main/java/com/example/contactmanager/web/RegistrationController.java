package com.example.contactmanager.web;

import com.example.contactmanager.entity.User;
import com.example.contactmanager.repository.UserRepository;
import com.example.contactmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String displayRegistrationForm() {
        return "registration";
    }

    @PostMapping("/registration")
    public String handleFruitForm(@RequestParam String firstname,
                                  @RequestParam String lastname,
                                  @RequestParam String pictureUrl,
                                  @RequestParam String email,
                                  @RequestParam String password, Model model) {

        Optional<User> optionalUser = userService.createUser(firstname, lastname, pictureUrl, email, password);
        optionalUser.ifPresent(user -> {
            model.addAttribute("user", optionalUser);
        });
        return optionalUser.isPresent() ? "redirect:/index" : "404";
    }
}
