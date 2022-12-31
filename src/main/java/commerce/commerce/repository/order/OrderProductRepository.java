package commerce.commerce.repository.order;

import commerce.commerce.model.order.OrderProduct;

public interface OrderProductRepository {
    void createOrderProduct(OrderProduct orderProduct);
    OrderProduct getOrderProductById(Long id);
    void updateOrderProductById(Long id, OrderProduct orderProduct);
    void deleteOrderProductById(Long id);
}
