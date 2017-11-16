package com.apress.prospring4.ch13;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Long> {
    Contact findByFirstName(String firstName);

    Contact findByFirstNameAndLastName(String firstName, String lastName);
}
