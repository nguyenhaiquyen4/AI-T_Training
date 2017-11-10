package com.apress.prospring4.ch6.listing6_35;

import java.util.List;
import javax.annotation.Resource;
import javax.sql.DataSource;

import com.apress.prospring4.ch6.listing6_3.Contact;
import com.apress.prospring4.ch6.listing6_32.ContactDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

@Repository("contactDao")
public class JdbcContactDao implements ContactDao {
    private static final Log LOG = LogFactory.getLog(JdbcContactDao.class);
    private DataSource dataSource;
    private SelectAllContacts selectAllContacts;

    @Override
    public List<Contact> findAll() {
        return selectAllContacts.execute();
    }

    @Override
    public List<Contact> findByFirstName(String firstName) {
        return null;
    }

    @Override
    public String findFirstNameById(Long id) {
        return null;
    }

    @Override
    public void insert(Contact contact) {
    }

    @Override
    public void update(Contact contact) {
    }

    @Resource(name = "dataSource")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.selectAllContacts = new SelectAllContacts(dataSource);
    }

    public DataSource getDataSource() {
        return dataSource;
    }
}