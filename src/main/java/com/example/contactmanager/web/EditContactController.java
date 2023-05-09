package com.example.contactmanager.web;

import com.example.contactmanager.entity.Contact;
import com.example.contactmanager.repository.ContactRepository;
import com.example.contactmanager.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class EditContactController {

    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private ContactService contactService;

   @GetMapping("/edit-contact")
   public String showEditContactForm(@RequestParam("id") Long id, Model model) {
       Contact contact = contactRepository.findById(id)
               .orElseThrow(() -> new IllegalArgumentException("Invalid contact id: " + id));
       model.addAttribute("contact", contact);
       return "edit-contact";
   }
}
