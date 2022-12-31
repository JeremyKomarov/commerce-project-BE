package commerce.commerce.service.customer;

import commerce.commerce.model.customer.Customer;
import commerce.commerce.repository.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void createCustomer(Customer customer) throws Exception {
        if (customer != null){
            Customer customerByUsername = customerRepository.getCustomerByUsername(customer.getUsername());
            if (customerByUsername == null ){
                Customer customerByEmail = customerRepository.getCustomerByEmail(customer.getEmail());
                if (customerByEmail == null){
                    customerRepository.createCustomer(customer);
                }else {
                    throw new Exception("Email is taken");
                }
            }else {
             throw new Exception("Username Taken");
            }
        }else {
            throw new Exception("Given customer is null");
        }
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.getCustomerById(id);
    }

    @Override
    public void updateCustomerById(Long id, Customer customer) {
        customerRepository.updateCustomerById(id, customer);
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.deleteCustomerById(id);
    }

    @Override
    public Customer getCustomerByUsername(String username) {
        return customerRepository.getCustomerByUsername(username);
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        return customerRepository.getCustomerByEmail(email);
    }
}

