package commerce.commerce.repository.customer;

import commerce.commerce.model.customer.WishlistProduct;
import commerce.commerce.model.inventory.Product;
import commerce.commerce.repository.customer.mapper.WishlistProductMapper;
import commerce.commerce.repository.inventory.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WishlistProductRepositoryImpl implements WishlistProductRepository {
    private static final String WISHLIST_PRODUCTS_TABLE_NAME = "wish_list";
    private static final String PRODUCTS_TABLE_NAME = "products";


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void createWishlistProduct(WishlistProduct wishlistProduct) {
        String sql = "INSERT INTO " + WISHLIST_PRODUCTS_TABLE_NAME + " (customer_id, product_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, wishlistProduct.getCustomerId(), wishlistProduct.getProductId());
    }

    @Override
    public WishlistProduct getWishlistProductById(Long id) {
        String sql = "SELECT * FROM " + WISHLIST_PRODUCTS_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new WishlistProductMapper(), id);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }

    @Override
    public void updateWishlistProductById(Long id, WishlistProduct wishlistProduct) {
        String sql = "UPDATE " + WISHLIST_PRODUCTS_TABLE_NAME + " SET customer_id=?, product_id=? WHERE id=?";
        jdbcTemplate.update(sql, wishlistProduct.getCustomerId(), wishlistProduct.getProductId(), id);
    }

    @Override
    public void deleteWishlistProductById(Long id) {
        String sql = "DELETE FROM " + WISHLIST_PRODUCTS_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Product> getAllWishlistProductsByCustomerId(Long customerId) {
        String sql = "SELECT I.id, I.name, I.view_description, I.full_description, I.price, I.img, I.quantity FROM " + WISHLIST_PRODUCTS_TABLE_NAME +
                " INNER JOIN " + PRODUCTS_TABLE_NAME + " AS I ON product_id = I.id WHERE customer_id=?";
        try {
            return jdbcTemplate.query(sql, new ProductMapper(), customerId);
        } catch (EmptyResultDataAccessException error) {
            return null;
        }
    }

    @Override
    public void deleteAllWishlistProductsByCustomerId(Long customerId) {
        String sql = "DELETE FROM " + WISHLIST_PRODUCTS_TABLE_NAME + " WHERE customer_id=?";
        jdbcTemplate.update(sql, customerId);
    }


}