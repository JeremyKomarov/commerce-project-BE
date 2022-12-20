package commerce.commerce.customer.repository;

import commerce.commerce.customer.model.Customer;
import commerce.commerce.customer.repository.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    private static final String CUSTOMERS_TABLE_NAME = "customers";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createCustomer(Customer customer) {
        String sql = "INSERT INTO " + CUSTOMERS_TABLE_NAME + " (first_name, last_name, email, phone_number, address) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getPhoneNumber(), customer.getAddress());
    }

    @Override
    public Customer getCustomerById(Long id) {
        String sql = "SELECT * FROM " + CUSTOMERS_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new CustomerMapper(), id);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }

    @Override
    public void updateCustomerById(Long id, Customer customer) {
        String sql = "UPDATE " + CUSTOMERS_TABLE_NAME + " SET first_name=?, last_name=?, email=?, phone_number=?, address=? " +
                "WHERE id=?";
        jdbcTemplate.update(sql, customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getPhoneNumber(), customer.getAddress(), id);
    }

    @Override
    public void deleteCustomerById(Long id) {
        String sql = "DELETE FROM " + CUSTOMERS_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql,id);
    }
}