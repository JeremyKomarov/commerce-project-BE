package commerce.commerce.inventory.repository;

import commerce.commerce.customer.repository.mapper.CustomerMapper;
import commerce.commerce.inventory.model.Item;
import commerce.commerce.inventory.repository.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepositoryImpl implements ItemRepository {
    private static final String ITEMS_TABLE_NAME = "items";

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void createItem(Item item) {
        String sql = "INSERT INTO " + ITEMS_TABLE_NAME + " (name, description, price, img, quantity) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, item.getName(), item.getDescription(), item.getPrice(), item.getImg(), item.getQuantity());
    }

    @Override
    public Item getItemById(Long id) {
        String sql = "SELECT * FROM " + ITEMS_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new ItemMapper(), id);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }

    @Override
    public void updateItemById(Long id, Item item) {
        String sql = "UPDATE " + ITEMS_TABLE_NAME + " SET name=?, description=?, price=?, img=?, quantity=? " +
                "WHERE id=?";
        jdbcTemplate.update(sql, item.getName(), item.getDescription(), item.getPrice(), item.getImg(), item.getQuantity(), id);
    }

    @Override
    public void deleteItemById(Long id) {
        String sql = "DELETE FROM " + ITEMS_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public List<Item> getAllItems() {
        String sql = "SELECT * FROM " + ITEMS_TABLE_NAME;
        try {
            return jdbcTemplate.query(sql, new ItemMapper());
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }

    @Override
    public List<Item> getAllAvailibleItems() {
        String sql = "SELECT * FROM " + ITEMS_TABLE_NAME + " WHERE QUANTITY > 0";
        try {
            return jdbcTemplate.query(sql, new ItemMapper());
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }



}