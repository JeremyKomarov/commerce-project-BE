package commerce.commerce.service.customer;

import commerce.commerce.model.customer.Customer;
import commerce.commerce.model.customer.CustomerProfileResponse;

public interface CustomerService {
    void createCustomer(Customer customer) throws Exception;
    Customer getCustomerById(Long id);
    void updateCustomerById(Long id, Customer customer);
    void deleteCustomerById(Long id) throws Exception;
    Customer getCustomerByUsername(String username);
    Customer getCustomerByEmail(String email);
    CustomerProfileResponse getCustomerProfile(String username) throws Exception;
}
