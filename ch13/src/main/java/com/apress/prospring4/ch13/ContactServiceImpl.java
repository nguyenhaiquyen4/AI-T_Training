package com.apress.prospring4.ch13;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.google.common.collect.Lists;

@Service("contactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public long countAll() {
        return 0;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findAll() {
        return Lists.newArrayList(contactRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Contact findByFirstName(String firstName) {
        return contactRepository.findByFirstName(firstName);
    }

    @Override
    @Transactional(readOnly = true)
    public Contact findById(Long id) {
        return contactRepository.findOne(id);
    }

    @Override
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public void delete(Contact contact) {
        contactRepository.delete(contact);
    }

    @Override
    @Transactional(readOnly=true)
    public Contact findByFirstNameAndLastName(
            String firstName, String lastName) {
        return contactRepository.findByFirstNameAndLastName(
                firstName, lastName);
    }
}