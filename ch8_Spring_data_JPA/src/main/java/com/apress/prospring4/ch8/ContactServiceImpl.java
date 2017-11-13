package com.apress.prospring4.ch8;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

@Service("springJpaContactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;

    @Transactional(readOnly = true)
    public List<Contact> findAll() {
        return Lists.newArrayList(contactRepository.findAll());
//        List<Contact> list = new ArrayList<>();
//        contactRepository.findAll().iterator().forEachRemaining(list::add);
//        return list;
    }

    @Transactional(readOnly = true)
    public List<Contact> findByFirstName(String firstName) {
        return contactRepository.findByFirstName(firstName);
    }

    @Transactional(readOnly = true)
    public List<Contact> findByFirstNameAndLastName(
            String firstName, String lastName) {
        return contactRepository.findByFirstNameAndLastName(
                firstName, lastName);
    }
}