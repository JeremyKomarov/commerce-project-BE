package commerce.commerce.controller.customer;

import commerce.commerce.model.customer.FavoriteProduct;
import commerce.commerce.service.customer.FavoriteProductService;
import commerce.commerce.model.inventory.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/favorite")
public class FavoriteProductController {
    @Autowired
    FavoriteProductService favoriteProductService;
    @CrossOrigin
    @PostMapping(value = "/create")
    public void createFavoriteProduct(@RequestBody FavoriteProduct favoriteProduct){
        favoriteProductService.createFavoriteProduct(favoriteProduct);
    }
    @CrossOrigin
    @GetMapping(value = "/{id}")
    public FavoriteProduct getFavoriteProductById(@PathVariable Long id){
        return favoriteProductService.getFavoriteProductById(id);
    }
    @CrossOrigin
    @PutMapping(value = "/{id}/update")
    public void updateFavoriteProductById(@PathVariable Long id,
                                   @RequestBody FavoriteProduct favoriteProduct){
        favoriteProductService.updateFavoriteProductById(id, favoriteProduct);
    }
    @CrossOrigin
    @DeleteMapping(value = "/{id}/delete")
    public void deleteFavoriteProductById(@PathVariable Long id){
        favoriteProductService.deleteFavoriteProductById(id);
    }
    @CrossOrigin
    @GetMapping(value = "/{customerId}/all")
    public List<Product> getAllFavoriteProductsByCustomerId(@PathVariable Long customerId){
        return favoriteProductService.getAllFavoriteProductsByCustomerId(customerId);
    }
}