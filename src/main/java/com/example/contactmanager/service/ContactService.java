package com.example.contactmanager.service;

import com.example.contactmanager.entity.Contact;
import com.example.contactmanager.entity.MeetingPlace;
import com.example.contactmanager.entity.Relationship;
import com.example.contactmanager.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;
    public void addContact(){
        Contact contact1 = new Contact(
                "Julie",
                "Bateau",
                "julieB@email.fr",
                "0651548546",
                "3 rue du chat",
                "Nantes","44000",
                new Relationship("Friend"),
                new MeetingPlace("College"));
        contactRepository.save(contact1);

        Contact contact2 = new Contact(
                "Asma",
                "Yaeh",
                "AsmaYB@email.fr",
                "0645789642",
                "6 street of the water tower",
                "London","EC2P 2E",
                new Relationship("New meeting"),
                new MeetingPlace("Holliday"));
        contactRepository.save(contact2);

    }

    public List<Contact> findAll(){
        List<Contact> contacts = contactRepository.findAll();
        return contacts;
    }

    public void createContact(String firstname,String lastname,String email, String phone,String address, String city, String zipCode, String typeRelationship,String meetingPlace){
        Contact contact = new Contact(
                firstname,
                lastname,
                email,
                phone,
                address,
                city,
                zipCode,
                new Relationship(typeRelationship),
                new MeetingPlace(meetingPlace));
        contactRepository.save(contact);
    }

    public Contact CreateNewContact(Contact contact){
        return contactRepository.save(contact);
    }

    public void deleteContact(Contact contact){
        contactRepository.delete(contact);
    }

    public Optional<Contact> findById(Long id){
        return contactRepository.findById(id);
    }

    public Contact updateContact(Contact contact){
        Optional<Contact> optionalContact = contactRepository.findById(contact.getId());

        if(optionalContact.isPresent()){
            Contact existingContact = optionalContact.get();
            existingContact.setFirstName(contact.getFirstName());
            existingContact.setLastName(contact.getLastName());
            existingContact.setEmail(contact.getEmail());
            existingContact.setPhoneNumber(contact.getPhoneNumber());
            existingContact.setAddress(contact.getAddress());
            existingContact.setCity(contact.getCity());
            existingContact.setPostalCode(contact.getPostalCode());
            existingContact.setRelationship(contact.getRelationship());
            existingContact.setMeetingPlace(contact.getMeetingPlace());
            return contactRepository.save(existingContact);
        }else{
            return null;
        }
    }
}
