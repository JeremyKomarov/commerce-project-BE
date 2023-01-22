package commerce.commerce.service.order;

import commerce.commerce.model.inventory.Product;
import commerce.commerce.model.order.OrderProduct;
import commerce.commerce.model.order.OrderProductCount;

import java.util.List;

public interface OrderProductService {
    Long createOrderProduct(OrderProduct orderProduct) throws Exception;
    OrderProduct getOrderProductById(Long id);
    void updateOrderProductById(Long id, OrderProduct orderProduct);
    void deleteOrderProductById(Long id) throws Exception;
    List<Product> getAllOrderProductsByCustomerId (Long customerId);
    void updateOrderIdByCustomerId(Long customerId, Long orderId);
    OrderProductCount countOrderProductWithOrderId(Long orderId);
    void deleteOrderProductsByCustomerIdWhereOrderIsOpen(Long customerId);
}
