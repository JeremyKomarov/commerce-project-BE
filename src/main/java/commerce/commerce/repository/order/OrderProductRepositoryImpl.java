package commerce.commerce.repository.order;

import commerce.commerce.model.inventory.Product;
import commerce.commerce.model.order.OrderProduct;
import commerce.commerce.repository.inventory.mapper.ProductMapper;
import commerce.commerce.repository.order.mapper.OrderProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderProductRepositoryImpl implements OrderProductRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String ORDER_PRODUCTS_TABLE_NAME = "order_products";
    private static final String PRODUCTS_TABLE_NAME = "products";


    @Override
    public void createOrderProduct(OrderProduct orderProduct) {
        String sql = "INSERT INTO " + ORDER_PRODUCTS_TABLE_NAME + " (order_id, customer_id, product_id, quantity, price) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, orderProduct.getOrderId(), orderProduct.getCustomerId() , orderProduct.getProductId(), orderProduct.getQuantity(), orderProduct.getPrice());
    }

    @Override
    public OrderProduct getOrderProductById(Long id) {
        String sql = "SELECT * FROM " + ORDER_PRODUCTS_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new OrderProductMapper(), id);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }

    @Override
    public void updateOrderProductById(Long id, OrderProduct orderProduct) {

    }

    @Override
    public void deleteOrderProductById(Long id) {
    }

    @Override
    public List<Product> getAllOrderProductsByCustomerId(Long customerId) {
        String sql = "SELECT " + PRODUCTS_TABLE_NAME + ".* FROM " + PRODUCTS_TABLE_NAME + " LEFT JOIN " + ORDER_PRODUCTS_TABLE_NAME + " ON " + PRODUCTS_TABLE_NAME +
                ".id = " + ORDER_PRODUCTS_TABLE_NAME + ".id WHERE " + ORDER_PRODUCTS_TABLE_NAME + ".customer_id =? AND " + ORDER_PRODUCTS_TABLE_NAME + ".order_id IS NULL";
        try {
            return jdbcTemplate.query(sql, new ProductMapper(), customerId);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }

    public void updateOrderIdByCustomerId(Long customerId, Long orderId) {
        String sql = "UPDATE " + ORDER_PRODUCTS_TABLE_NAME +" SET order_id = ? WHERE customer_id = ?";
        jdbcTemplate.update(sql, orderId, customerId);
    }


}
