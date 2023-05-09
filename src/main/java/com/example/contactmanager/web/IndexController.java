package com.example.contactmanager.web;

import com.example.contactmanager.entity.Contact;
import com.example.contactmanager.repository.ContactRepository;
import com.example.contactmanager.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private ContactService contactService;

    @GetMapping("/index")
    public String contact(Model model) {
        List<Contact> contactList = contactService.findAll();
        model.addAttribute("contacts", contactList);
        return "index";

    }

    @PostMapping("/index")
    public String deleteContact(@RequestParam("btnId") Long id) {
        contactRepository.deleteById(id);
        return "redirect:/index";
    }


}