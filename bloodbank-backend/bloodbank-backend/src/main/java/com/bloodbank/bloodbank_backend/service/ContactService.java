package com.bloodbank.bloodbank_backend.service;

import com.bloodbank.bloodbank_backend.entity.ContactEntity;
import com.bloodbank.bloodbank_backend.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public ContactEntity saveContact(ContactEntity contact) {
        return contactRepository.save(contact);
    }

    public List<ContactEntity> findAll() {
        return contactRepository.findAll();
    }

    public void deleteContactById(Long id) {
        contactRepository.deleteById(id);
    }
}
