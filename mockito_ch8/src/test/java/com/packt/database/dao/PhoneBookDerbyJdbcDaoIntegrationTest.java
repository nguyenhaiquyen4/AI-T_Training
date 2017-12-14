package com.packt.database.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.packt.database.AppConfig;
import com.packt.database.model.PhoneEntry;

//@SpringBootTest(classes = AppConfig.class)
//@RunWith(SpringRunner.class)
public class PhoneBookDerbyJdbcDaoIntegrationTest {
//    @Autowired
    PhoneBookDerbyDao jdbcDao;

    @Before
    public void init() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        jdbcDao = ctx.getBean("phoneBookDao", PhoneBookDerbyDao.class);
    }

    @Test
    public void integration() throws Exception {
        PhoneEntry entry = new PhoneEntry();
        entry.setFirstName("john");
        entry.setLastName("smith");
        entry.setPhoneNumber("12345");

        assertTrue(jdbcDao.create(entry));
        List<PhoneEntry> phoneEntries = jdbcDao.searchByFirstName("john");
        //verify create
        assertFalse(phoneEntries.isEmpty());

        //modify last name
        entry.setLastName("doe");
        //update
        assertTrue(jdbcDao.update(entry));
        //retrieve
        phoneEntries = jdbcDao.searchByFirstName("john");
        //verify update
        assertFalse(phoneEntries.isEmpty());
        assertEquals("doe", phoneEntries.get(0).getLastName());

        //delete
        jdbcDao.delete(entry.getPhoneNumber());
        //retrieve
        phoneEntries = jdbcDao.searchByFirstName("john");
        //verify delete
        assertTrue(phoneEntries.isEmpty());
    }

}
