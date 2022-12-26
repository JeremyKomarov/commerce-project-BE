package commerce.commerce.customer.repository;

import commerce.commerce.customer.model.Customer;
import commerce.commerce.customer.model.CustomerRequest;

public interface CustomerRepository {
    void createCustomer(Customer customer);
    Customer getCustomerById(Long id);
    void updateCustomerById(Long id, Customer customer);
    void deleteCustomerById(Long id);
    Customer getCustomerByUsername(String username);
    Customer getCustomerByEmail(String email);
}
