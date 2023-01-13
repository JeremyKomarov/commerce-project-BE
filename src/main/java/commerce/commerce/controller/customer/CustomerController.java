package commerce.commerce.controller.customer;

import commerce.commerce.model.customer.Customer;
import commerce.commerce.model.customer.CustomerProfileResponse;
import commerce.commerce.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customer")

public class CustomerController {
    @Autowired
    CustomerService customerService;
    @CrossOrigin
    @PostMapping(value = "/create")
    public void createCustomer(@RequestBody Customer customer) throws Exception {
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
    @GetMapping(value = "/email/{email}")
    public Customer getCustomerByEmail(@PathVariable String email){
        return customerService.getCustomerByEmail(email);
    }

    @CrossOrigin
    @GetMapping(value = "/profile/{username}")
    public CustomerProfileResponse getCustomerProfile(@PathVariable String username){
        return customerService.getCustomerProfile(username);
    }

}