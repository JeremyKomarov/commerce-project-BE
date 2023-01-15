package commerce.commerce.service.order;

import commerce.commerce.model.inventory.Product;
import commerce.commerce.model.order.OrderProduct;
import commerce.commerce.repository.order.OrderProductRepository;
import commerce.commerce.service.inventory.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProductServiceImpl implements OrderProductService {
    @Autowired
    OrderProductRepository orderProductRepository;
    @Autowired
    ProductService productService;

    @Override
    public void createOrderProduct(OrderProduct orderProduct) throws Exception {
        if (orderProduct != null) {
            Product curProduct = productService.getProductById(orderProduct.getProductId());
            if (curProduct != null){
                if (curProduct.getQuantity() > 0){
                    orderProductRepository.createOrderProduct(orderProduct);
                }else {
                    throw new Exception("product is out of stock");
                }
            }else {
                throw new Exception("product id " + curProduct.getId() + " is not exist");
            }
        }else {
            throw new Exception("orderProduct is empty");
        }
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

    @Override
    public List<Product> getAllOrderProductsByCustomerId(Long customerId) {
        return orderProductRepository.getAllOrderProductsByCustomerId(customerId);
    }

    @Override
    public void updateOrderIdByCustomerId(Long customerId, Long orderId) {
        orderProductRepository.updateOrderIdByCustomerId(customerId, orderId);
    }


}
