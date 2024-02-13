package com.example.Contactos.service;

import com.example.Contactos.entity.Contact;
import com.example.Contactos.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ContactService {
    private final ContactRepository contactRepository;

    public Iterable<Contact> findAll() {
        return contactRepository.findAll();
    }

    public Contact findById(Integer id){
        return contactRepository
                .findById(id)
                .orElse(null);
    }
    public Contact create(Contact contact){
        contact.setCreatedAt(LocalDateTime.now());
        return contactRepository.save(contact);
    }

    public Contact update(Integer id, Contact form){
        Contact contactFromDb = contactRepository
                .findById(id)
                .orElse(null);

        contactFromDb.setName(form.getName());
        contactFromDb.setEmail(form.getEmail());

        return contactRepository.save(contactFromDb);
    }

    public void delete (Integer id){
      Contact contactFromDb = findById(id);
      contactRepository.delete(contactFromDb);
    }
}
