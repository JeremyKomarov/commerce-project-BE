package commerce.commerce.repository.order;

import commerce.commerce.model.order.Order;
import commerce.commerce.repository.order.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    private static final String ORDERS_TABLE_NAME = "orders";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createOrder(Order order) {
        String sql = "INSERT INTO " + ORDERS_TABLE_NAME + " (customer_id, order_date, shipping_address, total_products, total_price, status) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, order.getCustomerId(), order.getOrderDate(), order.getShippingAddress(), order.getTotalProducts(), order.getTotalPrice(), order.getStatus());
    }

    @Override
    public Order getOrderById(Long id) {
        String sql = "SELECT * FROM " + ORDERS_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new OrderMapper(), id);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }

    @Override
    public void updateOrderById(Long id, Order order) {
        String sql = "UPDATE " + ORDERS_TABLE_NAME + " SET customer_id=?, order_date=?, shipping_address=?, total_products=?, total_price=?, status=? " +
                "WHERE id=?";
        jdbcTemplate.update(sql, order.getCustomerId(), order.getOrderDate(), order.getShippingAddress(), order.getTotalProducts(), order.getTotalPrice(), order.getStatus(), id);
    }

    @Override
    public void deleteOrderById(Long id) {
        String sql = "DELETE FROM " + ORDERS_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql,id);
    }
}