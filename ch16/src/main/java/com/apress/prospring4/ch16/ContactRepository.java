package com.apress.prospring4.ch16;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ContactRepository extends CrudRepository<Contact, Long> {
}
