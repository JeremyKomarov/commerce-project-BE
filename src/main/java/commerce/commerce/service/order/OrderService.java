package commerce.commerce.service.order;

import commerce.commerce.model.order.Order;

public interface OrderService {
    Long createOrder(Order order);
    Order getOrderById(Long id);
    void updateOrderById(Long id, Order order);
    void deleteOrderById(Long id);
    Order getOpenOrderByCustomerId(Long customerId);
}
