package commerce.commerce.repository.order;

import commerce.commerce.model.inventory.Product;
import commerce.commerce.model.order.OrderProduct;

import java.util.List;

public interface OrderProductRepository {
    void createOrderProduct(OrderProduct orderProduct);
    OrderProduct getOrderProductById(Long id);
    void updateOrderProductById(Long id, OrderProduct orderProduct);
    void deleteOrderProductById(Long id);
    List<Product> getAllOrderProductsByCustomerId(Long customerId);
    void updateOrderIdByCustomerId(Long customerId, Long orderId);
}
