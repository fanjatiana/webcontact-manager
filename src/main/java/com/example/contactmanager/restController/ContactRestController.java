package com.example.contactmanager.restController;
import com.example.contactmanager.entity.Contact;
import com.example.contactmanager.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contacts")
public class ContactRestController {
    @Autowired
    private ContactService contactService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Contact>> getAll() {
        List<Contact> contactList = contactService.findAll()
                .stream()
                .map(contact -> {
                    contact.setId(contact.getId());
                    contact.setFirstName(contact.getFirstName());
                    contact.setLastName(contact.getLastName());
                    contact.setEmail(contact.getEmail());
                    contact.setPhoneNumber(contact.getPhoneNumber());
                    contact.setAddress(contact.getAddress());
                    contact.setCity(contact.getCity());
                    contact.setPostalCode(contact.getPostalCode());
                    contact.setRelationship(contact.getRelationship());
                    contact.setMeetingPlace(contact.getMeetingPlace());
                    return contact;
                })
                .collect(Collectors.toList());
        return ResponseEntity
                .ok(contactList);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Contact> getById(@PathVariable Long id) {
        Optional<Contact> optionalContact = contactService.findById(id);
        if (optionalContact.isPresent()) {
            Contact contact = optionalContact.get();
            return ResponseEntity.ok(contact);
        } else {
            return ResponseEntity
                    .notFound()
                    .build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        Optional<Contact> optionalContact = contactService.findById(id);
        if (optionalContact.isPresent()) {
            Contact existingContact = optionalContact.get();
            contactService.deleteContact(existingContact);
            return ResponseEntity.noContent().build();

        } else {
            return ResponseEntity
                    .notFound()
                    .build();
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        Contact createdContact = contactService.CreateNewContact(contact);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdContact);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact contact) {
        Optional<Contact> optionalContact = contactService.findById(id);
        if (optionalContact.isPresent()) {
            Contact thisContact = optionalContact.get();
            thisContact.setFirstName(contact.getFirstName());
            thisContact.setLastName(contact.getLastName());
            thisContact.setEmail(contact.getEmail());
            thisContact.setPhoneNumber(contact.getPhoneNumber());
            thisContact.setAddress(contact.getAddress());
            thisContact.setCity(contact.getCity());
            thisContact.setPostalCode(contact.getPostalCode());
            thisContact.setRelationship(contact.getRelationship());
            thisContact.setMeetingPlace(contact.getMeetingPlace());
            Contact updatedContact = contactService.updateContact(thisContact);
            return ResponseEntity.ok(updatedContact);
        } else {
            return ResponseEntity
                    .notFound()
                    .build();
        }
    }
}
