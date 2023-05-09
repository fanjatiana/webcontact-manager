package com.example.contactmanager.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstname;
    private String lastname;
    private String pictureUrl;
    private String email;
    private String password;
   @ManyToMany
    @JoinTable(name = "user_contacts",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "contacts_id"))
    private List<Contact> contacts = new ArrayList<>();


    public User() {
    }

    public User(String firstname, String lastname, String pictureUrl, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.pictureUrl = pictureUrl;
        this.email = email;
        this.password = password;
    }

  public User(String firstname, String lastname, String pictureUrl, String email, String password, List<Contact> contacts) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.pictureUrl = pictureUrl;
        this.email = email;
        this.password = password;
        this.contacts = contacts;
    }

    public List<Contact> getContacts() {
        return contacts;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
