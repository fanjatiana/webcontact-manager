package com.example.contactmanager.web;

import com.example.contactmanager.entity.User;
import com.example.contactmanager.repository.UserRepository;
import com.example.contactmanager.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String displayLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String handleLoginForm(@RequestParam("email") String email,
                                  @RequestParam("password") String password,
                                  HttpSession session) {
        Optional<User> optionalUser = userRepository.findUserByEmailAndPassword(email, password);
        optionalUser.ifPresent(user -> {
            session.setAttribute("user", user);

        });
        return optionalUser.isPresent() ? "redirect:/index" : "404";

    }

}
