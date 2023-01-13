package commerce.commerce.repository.customer;

import commerce.commerce.model.customer.FavoriteProduct;
import commerce.commerce.repository.customer.mapper.FavoriteProductMapper;
import commerce.commerce.model.inventory.Product;
import commerce.commerce.repository.inventory.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FavoriteProductRepositoryImpl implements FavoriteProductRepository {
    private static final String FAVORITE_PRODUCTS_TABLE_NAME = "favorite_products";
    private static final String PRODUCTS_TABLE_NAME = "products";


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void createFavoriteProduct(FavoriteProduct favoriteProduct) {
        String sql = "INSERT INTO " + FAVORITE_PRODUCTS_TABLE_NAME + " (customer_id, product_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, favoriteProduct.getCustomerId(), favoriteProduct.getProductId());
    }

    @Override
    public FavoriteProduct getFavoriteProductById(Long id) {
        String sql = "SELECT * FROM " + FAVORITE_PRODUCTS_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new FavoriteProductMapper(), id);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }

    @Override
    public void updateFavoriteProductById(Long id, FavoriteProduct favoriteProduct) {
        String sql = "UPDATE " + FAVORITE_PRODUCTS_TABLE_NAME + " SET customer_id=?, product_id=? WHERE id=?";
        jdbcTemplate.update(sql, favoriteProduct.getCustomerId(), favoriteProduct.getProductId(), id);
    }

    @Override
    public void deleteFavoriteProductById(Long id) {
        String sql = "DELETE FROM " + FAVORITE_PRODUCTS_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Product> getAllFavoriteProductsByCustomerId(Long customerId) {
        String sql = "SELECT I.id, I.name, I.view_description, I.full_description, I.price, I.img, I.quantity FROM " + FAVORITE_PRODUCTS_TABLE_NAME +
                " INNER JOIN " + PRODUCTS_TABLE_NAME + " AS I ON product_id = I.id WHERE customer_id=?";
        try {
            return jdbcTemplate.query(sql, new ProductMapper(), customerId);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }
}