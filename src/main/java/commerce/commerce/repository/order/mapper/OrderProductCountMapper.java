package commerce.commerce.repository.order.mapper;

import commerce.commerce.model.order.OrderProductCount;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderProductCountMapper implements RowMapper<OrderProductCount> {
    @Override
    public OrderProductCount mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new OrderProductCount(
                rs.getLong("count")
        );
    }
}
