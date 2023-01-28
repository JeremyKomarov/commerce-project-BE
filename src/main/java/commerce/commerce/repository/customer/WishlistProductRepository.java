package commerce.commerce.repository.customer;

import commerce.commerce.model.customer.WishlistProduct;
import commerce.commerce.model.inventory.ProductResponse;

import java.util.List;

public interface WishlistProductRepository {
    Long createWishlistProduct(WishlistProduct wishlistProduct);
    WishlistProduct getWishlistProductById(Long id);
    void updateWishlistProductById(Long id, WishlistProduct wishlistProduct);
    void deleteWishlistProductById(Long id);
    List<ProductResponse> getAllWishlistProductsByCustomerId(Long customerId);
    void deleteAllWishlistProductsByCustomerId(Long customerId);

}
