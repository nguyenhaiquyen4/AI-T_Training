package com.apress.prospring4.ch6.listing6_44;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import javax.annotation.Resource;
import javax.sql.DataSource;

import com.apress.prospring4.ch6.listing6_3.Contact;
import com.apress.prospring4.ch6.listing6_3.ContactDao;
import com.apress.prospring4.ch6.listing6_35.SelectAllContacts;
import com.apress.prospring4.ch6.listing6_38.SelectContactByFirstName;
import com.apress.prospring4.ch6.listing6_41.UpdateContact;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

@Repository("contactDao")
public class JdbcContactDao implements ContactDao {
    private static final Log LOG = LogFactory.getLog(JdbcContactDao.class);
    private DataSource dataSource;
    private SelectAllContacts selectAllContacts;
    private SelectContactByFirstName selectContactByFirstName;
    private UpdateContact updateContact;
    private InsertContact insertContact;

    @Override
    public List<Contact> findAll() {
        return selectAllContacts.execute();
    }

    @Override
    public List<Contact> findByFirstName(String firstName) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("first_name", firstName);
        return selectContactByFirstName.executeByNamedParam(paramMap);
    }

    @Override
    public String findLastNameById(Long id) {
        return null;
    }

    @Override
    public String findFirstNameById(Long id) {
        return null;
    }

    @Override
    public void insert(Contact contact) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("first_name", contact.getFirstName());
        paramMap.put("last_name", contact.getLastName());
        paramMap.put("birth_date", contact.getBirthDate());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        insertContact.updateByNamedParam(paramMap, keyHolder);
        contact.setId(keyHolder.getKey().longValue());
        LOG.info("New contact inserted with id: " + contact.getId());
    }

    @Override
    public void update(Contact contact) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("first_name", contact.getFirstName());
        paramMap.put("last_name", contact.getLastName());
        paramMap.put("birth_date", contact.getBirthDate());
        paramMap.put("id", contact.getId());
        updateContact.updateByNamedParam(paramMap);
        LOG.info("Existing contact updated with id: " + contact.getId());
    }

    @Override
    public void delete(Long contactId) {

    }

    @Override
    public List<Contact> findAllWithDetail() {
        return null;
    }

    @Override
    public void insertWithDetail(Contact contact) {

    }

    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.selectAllContacts = new SelectAllContacts(dataSource);
        this.selectContactByFirstName = new SelectContactByFirstName(dataSource);
        this.updateContact = new UpdateContact(dataSource);
        this.insertContact = new InsertContact(dataSource);
    }

    public DataSource getDataSource() {
        return dataSource;
    }
}