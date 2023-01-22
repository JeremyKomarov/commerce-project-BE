package commerce.commerce.repository.order;

import commerce.commerce.model.inventory.Product;
import commerce.commerce.model.order.OrderProduct;
import commerce.commerce.model.order.OrderProductCount;
import commerce.commerce.repository.inventory.mapper.ProductMapper;
import commerce.commerce.repository.order.mapper.OrderProductCountMapper;
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
    private static final String ORDER_TABLE_NAME = "orders";
    private static final String PRODUCTS_TABLE_NAME = "products";


    @Override
    public Long createOrderProduct(OrderProduct orderProduct) {
        String sql = "INSERT INTO " + ORDER_PRODUCTS_TABLE_NAME + " (order_id, customer_id, product_id, quantity, price) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, orderProduct.getOrderId(), orderProduct.getCustomerId() , orderProduct.getProductId(), orderProduct.getQuantity(), orderProduct.getPrice());
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
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
        String sql = "DELETE FROM " + ORDER_PRODUCTS_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public List<Product> getAllOrderProductsByCustomerId(Long customerId, Long orderId) {
        String sql = "SELECT " + PRODUCTS_TABLE_NAME + ".* FROM " + PRODUCTS_TABLE_NAME + " LEFT JOIN " + ORDER_PRODUCTS_TABLE_NAME + " ON " + PRODUCTS_TABLE_NAME +
                ".id = " + ORDER_PRODUCTS_TABLE_NAME + ".id WHERE " + ORDER_PRODUCTS_TABLE_NAME + ".customer_id =? AND " + ORDER_PRODUCTS_TABLE_NAME + ".order_id =?";
        try {
            return jdbcTemplate.query(sql, new ProductMapper(), customerId, orderId);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }

    public void updateOrderIdByCustomerId(Long customerId, Long orderId) {
        String sql = "UPDATE " + ORDER_PRODUCTS_TABLE_NAME +" SET order_id = ? WHERE customer_id = ?";
        jdbcTemplate.update(sql, orderId, customerId);
    }

    @Override
    public OrderProductCount countOrderProductWithOrderId(Long orderId) {
        String sql = "SELECT order_id, COUNT(*) AS COUNT FROM " + ORDER_PRODUCTS_TABLE_NAME +" WHERE ORDER_ID = ? GROUP BY order_id;";
        return jdbcTemplate.queryForObject(sql, new OrderProductCountMapper(), orderId);
    }

    @Override
    public void deleteOrderProductsByCustomerIdWhereOrderIsOpen(Long customerId) {
        String sql = "DELETE FROM " + ORDER_PRODUCTS_TABLE_NAME + " WHERE order_id IN (SELECT id FROM " + ORDER_TABLE_NAME + " WHERE status = 'OPEN') "
                + "AND customer_id=?";
        jdbcTemplate.update(sql,customerId);
    }


}
