package commerce.commerce.service.inventory;

import commerce.commerce.model.inventory.Product;
import commerce.commerce.repository.inventory.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public void createProduct(Product product) {
        productRepository.createProduct(product);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.getProductById(id);
    }

    @Override
    public void updateProductById(Long id, Product product) {
        productRepository.updateProductById(id, product);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteProductById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public List<Product> getAllAvailibleProducts() {
        return productRepository.getAllAvailibleProducts();
    }
    @Override
    public void updateQuantity (Long productId, Long quantity) throws Exception {
        if (productId != null){
            Product curProduct = productRepository.getProductById(productId);
            if(curProduct != null){
                Long quantityToUpdate = curProduct.getQuantity() - 1;
                productRepository.updateQuantity(productId, quantityToUpdate);
            }else {
                throw new Exception(curProduct.getId() + "is not exist");
            }
        }else {
            throw new Exception("request is empty");
        }
    }
}

