package com.example.Contactos.repository;

import com.example.Contactos.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
