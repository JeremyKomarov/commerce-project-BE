package commerce.commerce.customer.repository;

import commerce.commerce.customer.model.FavoriteItem;
import commerce.commerce.inventory.model.Item;

import java.util.List;

public interface FavoriteItemRepository {
    void createFavoriteItem(FavoriteItem favoriteItem);
    FavoriteItem getFavoriteItemById(Long id);
    void updateFavoriteItemById(Long id, FavoriteItem favoriteItem);
    void deleteFavoriteItemById(Long id);
    List<Item> getAllFavoriteItemsByCustomerId(Long customerId);
}
