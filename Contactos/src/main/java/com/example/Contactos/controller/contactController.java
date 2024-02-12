package com.example.Contactos.controller;

import com.example.Contactos.entity.Contact;
import com.example.Contactos.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("api/contacts")
public class contactController {

    private final ContactService contactService;

    @GetMapping
    public Iterable<Contact> list( ){
        return contactService.findAll();
    }

    @GetMapping("{id}")
    public Contact get(@PathVariable Integer id){
        return contactService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Contact created(@RequestBody Contact contact){
    return contactService.create(contact);
    }
    @PutMapping("{id}")
    public Contact update (@PathVariable Integer id,
                           @RequestBody Contact form){
        return contactService.update(id, form);
    }

    @DeleteMapping("{id}")
    public void delete(Integer id){
        contactService.delete(id);
    }

}
