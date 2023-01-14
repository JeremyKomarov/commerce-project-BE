package commerce.commerce.service.order;

import commerce.commerce.model.customer.Customer;
import commerce.commerce.model.order.Order;
import commerce.commerce.repository.order.OrderRepository;
import commerce.commerce.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderProductService orderProductService;
    @Autowired
    CustomerService customerService;

    @Override
    public Long createOrder(Order order) {
        Customer curCustomer = customerService.getCustomerById(order.getCustomerId());
        Long newOrderId = orderRepository.createOrder(order);
        orderProductService.updateOrderIdByCustomerId(curCustomer.getId(), newOrderId);
       return newOrderId;
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.getOrderById(id);
    }

    @Override
    public void updateOrderById(Long id, Order order) {
        orderRepository.updateOrderById(id, order);
    }

    @Override
    public void deleteOrderById(Long id) {
        orderRepository.deleteOrderById(id);
    }
}
