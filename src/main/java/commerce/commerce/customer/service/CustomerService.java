package commerce.commerce.customer.service;

import commerce.commerce.customer.model.Customer;

public interface CustomerService {
    void createCustomer(Customer customer);
    Customer getCustomerById(Long id);
    void updateCustomerById(Long id, Customer customer);
    void deleteCustomerById(Long id);
}
