package commerce.commerce.customer.service;

import commerce.commerce.customer.model.Customer;
import commerce.commerce.customer.model.CustomerRequest;
import commerce.commerce.customer.repository.CustomerRepository;
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


    @Override
    public Customer loginCustomer(CustomerRequest customerRequest) throws Exception {
        if (customerRequest != null){
            Customer existCustomer = customerRepository.getCustomerByUsername(customerRequest.getUsername());
             if (existCustomer != null){
                 String givenPassword = customerRequest.getPassword();
                 if (givenPassword.equals( existCustomer.getPassword())){
                     return existCustomer;
                 } throw new Exception("Password Does Not Match ");
            }else {
                 throw new Exception("There is no such customer");
             }
        } else {
            throw new Exception("Customer Request Is Empty");
        }
    }
}

