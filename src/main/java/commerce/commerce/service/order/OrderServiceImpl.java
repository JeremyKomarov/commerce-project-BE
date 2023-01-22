package commerce.commerce.service.order;

import commerce.commerce.model.customer.Customer;
import commerce.commerce.model.order.Order;
import commerce.commerce.repository.order.OrderRepository;
import commerce.commerce.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
       return orderRepository.createOrder(order);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.getOrderById(id);
    }

    @Override
    public void updateOrderById(Long id, Order order) throws Exception {
        if (order != null){
            Customer existCustomer = customerService.getCustomerById(order.getCustomerId());
            if (existCustomer != null){
                Order curOrder = orderRepository.getOpenOrderByCustomerId(existCustomer.getId());
                if(curOrder.getStatus().equals("OPEN")){
                    order.setStatus("CLOSED");
                    orderRepository.updateOrderById(id, order);
                }else{
                 throw new Exception("Status Already Closed");
                }
            }else {
                throw new Exception("customer does not exist");
            }
        }else {
            throw new Exception("order is empty");
        }
    }

    @Override
    public void deleteOrderById(Long id) {
        orderRepository.deleteOrderById(id);
    }

    @Override
    public Order getOpenOrderByCustomerId(Long customerId) {
        return orderRepository.getOpenOrderByCustomerId(customerId);
    }

    @Override
    public void deleteOrdersByCustomerWhereIsOpen(Long customerId) {
        orderRepository.deleteOrdersByCustomerWhereIsOpen(customerId);
    }


}
