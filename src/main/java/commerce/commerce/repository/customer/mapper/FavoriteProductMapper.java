package commerce.commerce.repository.customer.mapper;

import commerce.commerce.model.customer.FavoriteProduct;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FavoriteProductMapper implements RowMapper<FavoriteProduct> {
    @Override
    public FavoriteProduct mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new FavoriteProduct(
                rs.getLong("id"),
                rs.getLong("customer_id"),
                rs.getLong("product_id")
        );
    }
}
