package com.apress.prospring4.ch9;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("contactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {
    @PersistenceContext(unitName = "emfA")
    private EntityManager emA;

    @PersistenceContext(unitName = "emfB")
    private EntityManager emB;

    @Override
    @Transactional(readOnly = true)
    public List<Contact> findAll() {
        return emB.createNamedQuery("Contact.findAll",
                Contact.class).getResultList();
//        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Contact findById(Long id) {
        TypedQuery<Contact> query = emA.createNamedQuery(
                "Contact.findById", Contact.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Contact save(Contact contact) {
        Contact contactB = new Contact();
        contactB.setFirstName(contact.getFirstName());
        contactB.setLastName(contact.getLastName());
        if (contact.getId() == null) {
            System.out.println("AAAAA:"+contact);
            emA.persist(contact);
            System.out.println("AAAAA:"+contactB);
            emB.persist(contactB);
            System.out.println("XXXXX");
            // throw new JpaSystemException(new PersistenceException());
        } else {
            emA.merge(contact);
            emB.merge(contactB);
        }
        return contact;
    }

    @Override
    public long countAll() {
        return 0;
    }
}