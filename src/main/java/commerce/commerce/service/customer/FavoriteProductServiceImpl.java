package commerce.commerce.service.customer;

import commerce.commerce.model.customer.FavoriteProduct;
import commerce.commerce.repository.customer.FavoriteProductRepository;
import commerce.commerce.model.inventory.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteProductServiceImpl implements FavoriteProductService {
    @Autowired
    FavoriteProductRepository favoriteProductRepository;

    @Override
    public void createFavoriteProduct(FavoriteProduct favoriteProduct) {
        favoriteProductRepository.createFavoriteProduct(favoriteProduct);
    }

    @Override
    public FavoriteProduct getFavoriteProductById(Long customerId) {
        return favoriteProductRepository.getFavoriteProductById(customerId);
    }

    @Override
    public void updateFavoriteProductById(Long id, FavoriteProduct favoriteProduct) {
        favoriteProductRepository.updateFavoriteProductById(id, favoriteProduct);
    }

    @Override
    public void deleteFavoriteProductById(Long id) {
        favoriteProductRepository.deleteFavoriteProductById(id);
    }

    @Override
    public  List<Product> getAllFavoriteProductsByCustomerId(Long customerId) {
        return favoriteProductRepository.getAllFavoriteProductsByCustomerId(customerId);
    }

    @Override
    public void deleteAllFavoriteProductsByCustomerId(Long customerId) {
        favoriteProductRepository.deleteAllFavoriteProductsByCustomerId(customerId);
    }


}
