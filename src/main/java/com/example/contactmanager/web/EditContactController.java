package com.example.contactmanager.web;

import com.example.contactmanager.entity.Contact;
import com.example.contactmanager.repository.ContactRepository;
import com.example.contactmanager.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class EditContactController {

    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private ContactService contactService;

   @GetMapping("/edit-contact")
    public String contact() {
        return "edit-contact";
    }

    @PostMapping("edit-contact/{id}")
    public String editContact(@PathVariable Long id, Model model) {
        Optional<Contact> optionalContact = contactRepository.findById(id);
        optionalContact.ifPresent(contact -> {
            model.addAttribute("contact", contact);
        });
        return optionalContact.isPresent() ? "edit-contact" : "404";

    }

    @PostMapping("/edit-contact")
    public String editContact(@ModelAttribute("contact") Contact contact) {
        contactRepository.save(contact);
        return "redirect:/index";
    }
}
