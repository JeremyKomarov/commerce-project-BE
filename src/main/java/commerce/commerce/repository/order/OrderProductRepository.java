package commerce.commerce.repository.order;

import commerce.commerce.model.inventory.Product;
import commerce.commerce.model.inventory.ProductResponse;
import commerce.commerce.model.order.OrderProduct;
import commerce.commerce.model.order.OrderProductCount;

import java.util.List;

public interface OrderProductRepository {
    Long createOrderProduct(OrderProduct orderProduct);
    OrderProduct getOrderProductById(Long id);
    void updateOrderProductById(Long id, OrderProduct orderProduct);
    void deleteOrderProductById(Long id);
    List<ProductResponse> getAllOrderProductsByCustomerId(Long customerId, Long orderId);
    List<Product> getAllOrderProductsByOrderId(Long orderId);
    void updateOrderIdByCustomerId(Long customerId, Long orderId);
    OrderProductCount countOrderProductWithOrderId(Long orderId);
    void deleteOrderProductsByCustomerId(Long customerId);


}
