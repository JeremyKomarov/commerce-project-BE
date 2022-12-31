package commerce.commerce.repository.order;

import commerce.commerce.model.order.OrderProduct;
import commerce.commerce.repository.order.mapper.OrderProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderProductRepositoryImpl implements OrderProductRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String ORDER_PRODUCTS_TABLE_NAME = "order_products";

    @Override
    public void createOrderProduct(OrderProduct orderProduct) {
        String sql = "INSERT INTO " + ORDER_PRODUCTS_TABLE_NAME + " (order_id, product_id, quantity, price) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, orderProduct.getOrderId(), orderProduct.getProductId(), orderProduct.getQuantity(), orderProduct.getPrice());
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
}
