package commerce.commerce.service.customer;

import commerce.commerce.model.customer.WishlistProduct;
import commerce.commerce.model.inventory.Product;
import commerce.commerce.repository.customer.WishlistProductRepository;
import commerce.commerce.service.inventory.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistProductServiceImpl implements WishlistProductService {
    @Autowired
    WishlistProductRepository wishlistProductRepository;

    @Autowired
    ProductService productService;

    @Override
    public void createWishlistProduct(WishlistProduct wishlistProduct) throws Exception {
        if (wishlistProduct != null){
            Product wantedProduct = productService.getProductById(wishlistProduct.getProductId());
                if (wantedProduct != null){


                }else {
                    throw new Exception("No such product");
                }
        }else {
            throw new Exception("no wishlist product to add");
        }
        wishlistProductRepository.createWishlistProduct(wishlistProduct);
    }

    @Override
    public WishlistProduct getWishlistProductById(Long customerId) {
        return wishlistProductRepository.getWishlistProductById(customerId);
    }

    @Override
    public void updateWishlistProductById(Long id, WishlistProduct wishlistProduct) {
        wishlistProductRepository.updateWishlistProductById(id, wishlistProduct);
    }

    @Override
    public void deleteWishlistProductById(Long id) {
        wishlistProductRepository.deleteWishlistProductById(id);
    }

    @Override
    public  List<Product> getAllWishlistProductsByCustomerId(Long customerId) {
        return wishlistProductRepository.getAllWishlistProductsByCustomerId(customerId);
    }

    @Override
    public void deleteAllWishlistProductsByCustomerId(Long customerId) {
        wishlistProductRepository.deleteAllWishlistProductsByCustomerId(customerId);
    }


}
