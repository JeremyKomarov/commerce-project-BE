package commerce.commerce.inventory.controller;

import commerce.commerce.inventory.model.Item;
import commerce.commerce.inventory.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/item")
@CrossOrigin
public class ItemController {
    @Autowired
    ItemService itemService;

    @PostMapping(value = "/create")
    public void createItem(@RequestBody Item item){
        itemService.createItem(item);
    }

    @GetMapping(value = "/{id}")
    public Item getItemById(@PathVariable Long id){
        return itemService.getItemById(id);
    }

    @PutMapping(value = "/{id}/update")
    public void updateItemById(@PathVariable Long id,
                               @RequestBody Item item){
        itemService.updateItemById(id, item);
    }

    @DeleteMapping(value = "/{id}/delete")
    public void deleteItemById(@PathVariable Long id){
        itemService.deleteItemById(id);
    }

    @GetMapping(value = "/all")
    public List<Item> getAllItems(){
        return itemService.getAllItems();
    };

    @GetMapping(value = "/availible")
    public List<Item> getAllAvailibleItems(){
        return itemService.getAllAvailibleItems();
    };
}
