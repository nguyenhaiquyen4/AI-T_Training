package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Customer> getAllCustomers() {
        Map<String, Object> params = new HashMap<String,
                Object>();
        List<Customer> result = jdbcTemplate.query("SELECT * FROM customers", params, new CustomerRepositoryImpl.CustomerMapper());
        return result;
    }

    //
    @Override
    public void addCustomer(Customer customer) {
        String SQL = "INSERT INTO Customers (ID, "
                + "NAME,"
                + "ADDRESS,"
                + "NOOFORDERSMADE) "
                + "VALUES (:id, :name, :address, :noofordersmade)";
        Map<String, Object> params = new HashMap<>();
        params.put("id", customer.getCustomerId());
        params.put("name", customer.getName());
        params.put("address", customer.getAddress());
        params.put("noofordersmade", customer.getNoOfOrdersMade());
        jdbcTemplate.update(SQL, params);
    }

    private static final class CustomerMapper implements
            RowMapper<Customer> {
        public Customer mapRow(ResultSet rs, int rowNum)
                throws SQLException {
            Customer customer = new Customer();
            customer.setCustomerId(rs.getString("ID"));
            customer.setName(rs.getString("NAME"));
            customer.setAddress(rs.getString("ADDRESS"));
            customer.setNoOfOrdersMade(rs.getLong("NOOFORDERSMADE"));
            return customer;
        }
    }
}
