package commerce.commerce.customer.service;

import commerce.commerce.customer.model.FavoriteItem;
import commerce.commerce.inventory.model.Item;

import java.util.List;

public interface FavoriteItemService {
    void createFavoriteItem(FavoriteItem favoriteItem);
    FavoriteItem getFavoriteItemById(Long id);
    void updateFavoriteItemById(Long id, FavoriteItem favoriteItem);
    void deleteFavoriteItemById(Long id);
    List<Item> getAllFavoriteItemsByCustomerId(Long customerId);
}
