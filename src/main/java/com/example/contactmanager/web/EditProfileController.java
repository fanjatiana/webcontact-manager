package com.example.contactmanager.web;

import com.example.contactmanager.entity.Contact;
import com.example.contactmanager.entity.User;
import com.example.contactmanager.repository.ContactRepository;
import com.example.contactmanager.repository.UserRepository;
import com.example.contactmanager.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EditProfileController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/edit-profile")
    public String showEditProfileForm(@RequestParam("id") Long id, Model model) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid contact id: " + id));
        model.addAttribute("user", user);
        return "edit-profile";
    }

    @PostMapping("/edit-profile")
    public String updateContact(@ModelAttribute("contact") User user) {
        userRepository.save(user);
        return "redirect:/profile";
    }
}
