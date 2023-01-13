package commerce.commerce.repository.customer;

import commerce.commerce.model.customer.Customer;
import commerce.commerce.model.customer.CustomerProfileResponse;

public interface CustomerRepository {
    void createCustomer(Customer customer);
    Customer getCustomerById(Long id);
    void updateCustomerById(Long id, Customer customer);
    void deleteCustomerById(Long id);
    Customer getCustomerByUsername(String username);
    Customer getCustomerByEmail(String email);
}
