package commerce.commerce.repository.order.mapper;

import commerce.commerce.model.order.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Order(
                rs.getLong("id"),
                rs.getLong("customer_id"),
                rs.getDate("order_date").toLocalDate(),
                rs.getString("country"),
                rs.getString("city"),
                rs.getString("phone_number"),
                rs.getLong("total_products"),
                rs.getDouble("total_price"),
                rs.getString("status")
                );
    }
}
