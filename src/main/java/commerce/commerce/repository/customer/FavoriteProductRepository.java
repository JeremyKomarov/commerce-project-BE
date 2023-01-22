package commerce.commerce.repository.customer;

import commerce.commerce.model.customer.FavoriteProduct;
import commerce.commerce.model.inventory.Product;

import java.util.List;

public interface FavoriteProductRepository {
    void createFavoriteProduct(FavoriteProduct favoriteProduct);
    FavoriteProduct getFavoriteProductById(Long id);
    void updateFavoriteProductById(Long id, FavoriteProduct favoriteProduct);
    void deleteFavoriteProductById(Long id);
    List<Product> getAllFavoriteProductsByCustomerId(Long customerId);
    void deleteAllFavoriteProductsByCustomerId(Long customerId);

}
