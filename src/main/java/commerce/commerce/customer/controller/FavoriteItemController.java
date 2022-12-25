package commerce.commerce.customer.controller;

import commerce.commerce.customer.model.Customer;
import commerce.commerce.customer.model.FavoriteItem;
import commerce.commerce.customer.service.FavoriteItemService;
import commerce.commerce.inventory.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/favorite")
public class FavoriteItemController {
    @Autowired
    FavoriteItemService favoriteItemService;

    @PostMapping(value = "/create")
    public void createFavoriteItem(@RequestBody FavoriteItem favoriteItem){
        favoriteItemService.createFavoriteItem(favoriteItem);
    }

    @GetMapping(value = "/{id}")
    public FavoriteItem getFavoriteItemById(@PathVariable Long id){
        return favoriteItemService.getFavoriteItemById(id);
    }

    @PutMapping(value = "/{id}/update")
    public void updateFavoriteItemById(@PathVariable Long id,
                                   @RequestBody FavoriteItem favoriteItem ){
        favoriteItemService.updateFavoriteItemById(id, favoriteItem);
    }

    @DeleteMapping(value = "/{id}/delete")
    public void deleteFavoriteItemById(@PathVariable Long id){
        favoriteItemService.deleteFavoriteItemById(id);
    }

    @GetMapping(value = "/{customerId}/all")
    public List<Item> getAllFavoriteItemsByCustomerId(@PathVariable Long customerId){
        return favoriteItemService.getAllFavoriteItemsByCustomerId(customerId);
    }
}