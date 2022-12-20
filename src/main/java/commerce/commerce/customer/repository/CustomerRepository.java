package commerce.commerce.customer.repository;

import commerce.commerce.customer.model.Customer;

public interface CustomerRepository {
    void createCustomer(Customer customer);
    Customer getCustomerById(Long id);
    void updateCustomerById(Long id, Customer customer);
    void deleteCustomerById(Long id);
}
