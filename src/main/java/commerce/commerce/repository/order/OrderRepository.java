package commerce.commerce.repository.order;

import commerce.commerce.model.inventory.Product;
import commerce.commerce.model.order.Order;

public interface OrderRepository {
    void createOrder(Order order);
    Order getOrderById(Long id);
    void updateOrderById(Long id, Order order);
    void deleteOrderById(Long id);
}