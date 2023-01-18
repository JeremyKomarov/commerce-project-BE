package commerce.commerce.service.inventory;

import commerce.commerce.model.inventory.Product;

import java.util.List;

public interface ProductService {
    void createProduct(Product product);
    Product getProductById(Long id);
    void updateProductById(Long id, Product product);
    void deleteProductById(Long id);
    List<Product> getAllProducts();
    List<Product> getAllAvailibleProducts();
    void updateQuantity (Long productId, Long quantityToUpdate) throws Exception;
}