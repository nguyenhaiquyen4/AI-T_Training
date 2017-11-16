package com.apress.prospring4.ch13;

import java.util.List;

public interface ContactService {

    long countAll();

    List<Contact> findAll();

    Contact findByFirstName(String firstName);

    Contact findById(Long id);

    Contact save(Contact contact);

    void delete(Contact contact);

    Contact findByFirstNameAndLastName(String firstName, String lastName);
}