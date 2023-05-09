package com.example.contactmanager.web;
import com.example.contactmanager.entity.User;
import com.example.contactmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Optional;

@Controller
public class ProfileController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/profile")
    public String showProfile( Model model) {
        Long id = 1L;
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            model.addAttribute("user", user);
            return "profile";
        } else {
            return "404";
        }
    }
}
