package com.example.contactmanager.web;

import com.example.contactmanager.entity.Contact;
import com.example.contactmanager.repository.ContactRepository;
import com.example.contactmanager.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CreateContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping("/create-contact")
    public String contact(Model model) {
        return "create-contact";
    }

    @PostMapping("/create-contact")
    public String handleContactForm(@RequestParam String firstname,
                                    @RequestParam String lastname,
                                    @RequestParam String email,
                                    @RequestParam String phone,
                                    @RequestParam String address,
                                    @RequestParam String city,
                                    @RequestParam String zipCode,
                                    @RequestParam String typeRelationship,
                                    @RequestParam String meetingPlace) {
       contactService.createContact(firstname,lastname,email,phone,address,city,zipCode,typeRelationship,meetingPlace);
        return "redirect:/index";
    }

}
