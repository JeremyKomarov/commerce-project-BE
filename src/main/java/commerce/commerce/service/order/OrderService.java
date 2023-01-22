package commerce.commerce.service.order;

import commerce.commerce.model.order.Order;

public interface OrderService {
    Long createOrder(Order order);
    Order getOrderById(Long id);
    void updateOrderById(Long id, Order order) throws Exception;
    void deleteOrderById(Long id);
    Order getOpenOrderByCustomerId(Long customerId);
    void deleteOrdersByCustomerWhereIsOpen(Long customerId);
}
