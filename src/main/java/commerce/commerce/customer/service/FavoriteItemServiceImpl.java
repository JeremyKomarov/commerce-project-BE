package commerce.commerce.customer.service;

import commerce.commerce.customer.model.FavoriteItem;
import commerce.commerce.customer.repository.FavoriteItemRepository;
import commerce.commerce.inventory.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteItemServiceImpl implements FavoriteItemService {
    @Autowired
    FavoriteItemRepository favoriteItemRepository;

    @Override
    public void createFavoriteItem(FavoriteItem favoriteItem) {
        favoriteItemRepository.createFavoriteItem(favoriteItem);
    }

    @Override
    public FavoriteItem getFavoriteItemById(Long customerId) {
        return favoriteItemRepository.getFavoriteItemById(customerId);
    }

    @Override
    public void updateFavoriteItemById(Long id, FavoriteItem favoriteItem) {
        favoriteItemRepository.updateFavoriteItemById(id, favoriteItem);
    }

    @Override
    public void deleteFavoriteItemById(Long id) {
        favoriteItemRepository.deleteFavoriteItemById(id);
    }

    @Override
    public  List<Item> getAllFavoriteItemsByCustomerId(Long customerId) {
        return favoriteItemRepository.getAllFavoriteItemsByCustomerId(customerId);
    }
}
