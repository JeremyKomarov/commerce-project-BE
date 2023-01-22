package commerce.commerce.repository.order;

import commerce.commerce.model.inventory.Product;
import commerce.commerce.model.order.OrderProduct;
import commerce.commerce.model.order.OrderProductCount;

import java.util.List;

public interface OrderProductRepository {
    Long createOrderProduct(OrderProduct orderProduct);
    OrderProduct getOrderProductById(Long id);
    void updateOrderProductById(Long id, OrderProduct orderProduct);
    void deleteOrderProductById(Long id);
    List<Product> getAllOrderProductsByCustomerId(Long customerId, Long orderId);
    void updateOrderIdByCustomerId(Long customerId, Long orderId);
    OrderProductCount countOrderProductWithOrderId(Long orderId);
    void deleteOrderProductsByCustomerIdWhereOrderIsOpen(Long customerId);

}
