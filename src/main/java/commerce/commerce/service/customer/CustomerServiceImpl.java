package commerce.commerce.service.customer;

import commerce.commerce.model.customer.Customer;
import commerce.commerce.model.customer.CustomerProfileResponse;
import commerce.commerce.model.inventory.Product;
import commerce.commerce.repository.customer.CustomerRepository;
import commerce.commerce.service.order.OrderProductService;
import commerce.commerce.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    WishlistProductService wishlistProductService;
    @Autowired
    OrderProductService orderProductService;
    @Autowired
    OrderService orderService;


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
    public void deleteCustomerById(Long id) throws Exception {
        if (id != null){
            Customer cutsomerToDelete = customerRepository.getCustomerById(id);
            if (cutsomerToDelete != null){
                wishlistProductService.deleteAllWishlistProductsByCustomerId(id);
                orderProductService.deleteOrderProductsByCustomerId(id);
                orderService.deleteOrdersByCustomerId(id);
                customerRepository.deleteCustomerById(id);
            }else{
                throw new Exception("No such customer with this id " + id);
            }
        }else {
            throw new Exception("Id is null");
        }
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
    public CustomerProfileResponse getCustomerProfile(String username) {
        Customer curCustomer = customerRepository.getCustomerByUsername(username);
        List<Product> curWishlistProducts = wishlistProductService.getAllWishlistProductsByCustomerId(curCustomer.getId());
        List<Product> curCartProducts = orderProductService.getAllOrderProductsByCustomerId(curCustomer.getId());

        CustomerProfileResponse existCustomerProfile = new CustomerProfileResponse(
                curCustomer,
                curWishlistProducts,
                curCartProducts
        );
        return existCustomerProfile;
    }
}

