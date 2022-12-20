package commerce.commerce.customer.controller;

import commerce.commerce.customer.model.Customer;
import commerce.commerce.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PostMapping(value = "/create")
    public void createCustomer(@RequestBody Customer customer){
        customerService.createCustomer(customer);
    }

    @GetMapping(value = "/{id}")
    public Customer getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }

    @PutMapping(value = "/{id}/update")
    public void updateCustomerById(@PathVariable Long id,
                               @RequestBody Customer customer ){
        customerService.updateCustomerById(id, customer);
    }

    @DeleteMapping(value = "/{id}/delete")
    public void deleteCustomerById(@PathVariable Long id){
        customerService.deleteCustomerById(id);
    }


}