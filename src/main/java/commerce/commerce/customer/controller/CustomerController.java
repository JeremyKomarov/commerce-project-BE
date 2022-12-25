package commerce.commerce.customer.controller;

import commerce.commerce.customer.model.Customer;
import commerce.commerce.customer.model.CustomerRequest;
import commerce.commerce.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")

public class CustomerController {
    @Autowired
    CustomerService customerService;
    @CrossOrigin
    @PostMapping(value = "/create")
    public void createCustomer(@RequestBody Customer customer){
        customerService.createCustomer(customer);
    }
    @CrossOrigin
    @GetMapping(value = "/id/{id}")
    public Customer getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }
    @CrossOrigin
    @PutMapping(value = "/{id}/update")
    public void updateCustomerById(@PathVariable Long id,
                               @RequestBody Customer customer ){
        customerService.updateCustomerById(id, customer);
    }
    @CrossOrigin
    @DeleteMapping(value = "/{id}/delete")
    public void deleteCustomerById(@PathVariable Long id){
        customerService.deleteCustomerById(id);
    }
    @CrossOrigin
    @GetMapping(value = "/username/{username}")
    public Customer getCustomerByUsername(@PathVariable String username){
        return customerService.getCustomerByUsername(username);
    }
    @CrossOrigin
    @PostMapping(value = "/login")
    public Customer loginCustomer(@RequestBody CustomerRequest customerRequest) throws Exception {
        System.out.println(customerRequest.getUsername());
        System.out.println(customerRequest.getPassword());
        return customerService.loginCustomer(customerRequest);
    }

}