package commerce.commerce.service.customer;

import commerce.commerce.model.customer.FavoriteProduct;
import commerce.commerce.model.inventory.Product;

import java.util.List;

public interface FavoriteProductService {
    void createFavoriteProduct(FavoriteProduct favoriteProduct);
    FavoriteProduct getFavoriteProductById(Long id);
    void updateFavoriteProductById(Long id, FavoriteProduct favoriteProduct);
    void deleteFavoriteProductById(Long id);
    List<Product> getAllFavoriteProductsByCustomerId(Long customerId);

}
