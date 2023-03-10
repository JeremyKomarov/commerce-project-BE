package commerce.commerce.controller.customer;

import commerce.commerce.model.customer.WishlistProduct;
import commerce.commerce.model.inventory.ProductResponse;
import commerce.commerce.service.customer.WishlistProductService;
import commerce.commerce.model.inventory.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/wishlist")
public class WishlistProductController {
    @Autowired
    WishlistProductService wishlistProductService;
    @CrossOrigin
    @PostMapping(value = "/create")
    public Long createWishlistProductProduct(@RequestBody WishlistProduct wishlistProduct) throws Exception {
        return wishlistProductService.createWishlistProduct(wishlistProduct);
    }
    @CrossOrigin
    @GetMapping(value = "/{id}")
    public WishlistProduct getWishlistProductById(@PathVariable Long id){
        return wishlistProductService.getWishlistProductById(id);
    }
    @CrossOrigin
    @PutMapping(value = "/{id}/update")
    public void updateWishlistProductById(@PathVariable Long id,
                                   @RequestBody WishlistProduct wishlistProduct){
        wishlistProductService.updateWishlistProductById(id, wishlistProduct);
    }
    @CrossOrigin
    @DeleteMapping(value = "/{id}/delete")
    public void deleteWishlistProductById(@PathVariable Long id){
        wishlistProductService.deleteWishlistProductById(id);
    }
    @CrossOrigin
    @GetMapping(value = "/{customerId}/all")
    public List<ProductResponse> getAllWishlistProductsByCustomerId(@PathVariable Long customerId){
        return wishlistProductService.getAllWishlistProductsByCustomerId(customerId);
    }
}