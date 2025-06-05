package com.bloodbank.bloodbank_backend.controller;

import com.bloodbank.bloodbank_backend.entity.ContactEntity;
import com.bloodbank.bloodbank_backend.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("/contact")
    public ContactEntity newContact(@RequestBody ContactEntity newContact) {
        return contactService.saveContact(newContact);
    }

    @GetMapping("/contact")
    public List<ContactEntity> getAllContacts() {
        return contactService.findAll();
    }

    @DeleteMapping("/contact/{id}")
    public void deleteContact(@PathVariable Long id) {
        contactService.deleteContactById(id);
    }
}
