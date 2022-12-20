package commerce.commerce.inventory.repository;

import commerce.commerce.inventory.model.Item;

import java.util.List;

public interface ItemRepository {
    void createItem(Item item);
    Item getItemById(Long id);
    void updateItemById(Long id, Item item);
    void deleteItemById(Long id);
    List<Item> getAllItems();
    List<Item> getAllAvailibleItems();

}