package commerce.commerce.customer.repository.mapper;

import commerce.commerce.customer.model.FavoriteItem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FavoriteItemMapper implements RowMapper<FavoriteItem> {
    @Override
    public FavoriteItem mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new FavoriteItem(
                rs.getLong("id"),
                rs.getLong("customer_id"),
                rs.getLong("item_id")
        );
    }
}
