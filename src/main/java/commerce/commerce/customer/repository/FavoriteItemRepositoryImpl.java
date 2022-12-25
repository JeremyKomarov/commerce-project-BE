package commerce.commerce.customer.repository;

import commerce.commerce.customer.model.FavoriteItem;
import commerce.commerce.customer.repository.mapper.FavoriteItemMapper;
import commerce.commerce.inventory.model.Item;
import commerce.commerce.inventory.repository.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FavoriteItemRepositoryImpl implements FavoriteItemRepository {
    private static final String FAVORITE_ITEMS_TABLE_NAME = "favorite_items";
    private static final String ITEMS_TABLE_NAME = "items";


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void createFavoriteItem(FavoriteItem favoriteItem) {
        String sql = "INSERT INTO " + FAVORITE_ITEMS_TABLE_NAME + " (customer_id, item_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, favoriteItem.getCustomerId(), favoriteItem.getItemId());
    }

    @Override
    public FavoriteItem getFavoriteItemById(Long id) {
        String sql = "SELECT * FROM " + FAVORITE_ITEMS_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new FavoriteItemMapper(), id);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }

    @Override
    public void updateFavoriteItemById(Long id, FavoriteItem favoriteItem) {
        String sql = "UPDATE " + FAVORITE_ITEMS_TABLE_NAME + " SET customer_id=?, item_id=? WHERE id=?";
        jdbcTemplate.update(sql, favoriteItem.getCustomerId(), favoriteItem.getItemId(), id);
    }

    @Override
    public void deleteFavoriteItemById(Long id) {
        String sql = "DELETE FROM " + FAVORITE_ITEMS_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Item> getAllFavoriteItemsByCustomerId(Long customerId) {
        String sql = "SELECT I.id, I.name, I.description, I.price, I.img, I.quantity FROM " + FAVORITE_ITEMS_TABLE_NAME +
                " INNER JOIN " + ITEMS_TABLE_NAME + " AS I ON item_id = I.id WHERE customer_id=?";
        try {
            return jdbcTemplate.query(sql, new ItemMapper(), customerId);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }
}