package commerce.commerce.repository.inventory.mapper;

import commerce.commerce.model.inventory.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Product(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("view_description"),
                rs.getString("full_description"),
                rs.getDouble("price"),
                rs.getString("img"),
                rs.getLong("quantity")
        );
    }
}
