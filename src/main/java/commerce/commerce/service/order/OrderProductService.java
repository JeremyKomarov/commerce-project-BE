package commerce.commerce.service.order;

import commerce.commerce.model.inventory.Product;
import commerce.commerce.model.order.OrderProduct;

import java.util.List;

public interface OrderProductService {
    void createOrderProduct(OrderProduct orderProduct) throws Exception;
    OrderProduct getOrderProductById(Long id);
    void updateOrderProductById(Long id, OrderProduct orderProduct);
    void deleteOrderProductById(Long id);
    List<Product> getAllOrderProductsByCustomerId (Long customerId);
    void updateOrderIdByCustomerId(Long customerId, Long orderId);

}
