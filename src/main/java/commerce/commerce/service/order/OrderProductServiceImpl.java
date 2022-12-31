package commerce.commerce.service.order;

import commerce.commerce.model.order.OrderProduct;
import commerce.commerce.repository.order.OrderProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderProductServiceImpl implements OrderProductService {
    @Autowired
    OrderProductRepository orderProductRepository;

    @Override
    public void createOrderProduct(OrderProduct orderProduct) {
        orderProductRepository.createOrderProduct(orderProduct);
    }

    @Override
    public OrderProduct getOrderProductById(Long id) {
        return orderProductRepository.getOrderProductById(id);
    }

    @Override
    public void updateOrderProductById(Long id, OrderProduct orderProduct) {
        orderProductRepository.updateOrderProductById(id, orderProduct);
    }

    @Override
    public void deleteOrderProductById(Long id) {
        orderProductRepository.deleteOrderProductById(id);
    }
}
