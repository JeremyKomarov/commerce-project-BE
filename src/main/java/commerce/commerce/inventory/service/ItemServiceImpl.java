package commerce.commerce.inventory.service;

import commerce.commerce.inventory.model.Item;
import commerce.commerce.inventory.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemRepository itemRepository;

    @Override
    public void createItem(Item item) {
        itemRepository.createItem(item);
    }

    @Override
    public Item getItemById(Long id) {
        return itemRepository.getItemById(id);
    }

    @Override
    public void updateItemById(Long id, Item item) {
        itemRepository.updateItemById(id, item);
    }

    @Override
    public void deleteItemById(Long id) {
        itemRepository.deleteItemById(id);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.getAllItems();
    }

    public List<Item> getAllAvailibleItems() {
        return itemRepository.getAllAvailibleItems();
    }




}

