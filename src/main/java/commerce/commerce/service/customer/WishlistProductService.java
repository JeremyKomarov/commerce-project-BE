package commerce.commerce.service.customer;

import commerce.commerce.model.customer.WishlistProduct;
import commerce.commerce.model.inventory.ProductResponse;

import java.util.List;

public interface WishlistProductService {
    Long createWishlistProduct(WishlistProduct wishlistProduct) throws Exception;
    WishlistProduct getWishlistProductById(Long id);
    void updateWishlistProductById(Long id, WishlistProduct wishlistProduct);
    void deleteWishlistProductById(Long id);
    List<ProductResponse> getAllWishlistProductsByCustomerId(Long customerId);
    void deleteAllWishlistProductsByCustomerId(Long customerId);


}
