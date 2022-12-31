package commerce.commerce.controller.inventory;

import commerce.commerce.model.inventory.Product;
import commerce.commerce.service.inventory.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
@CrossOrigin
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping(value = "/create")
    public void createProduct(@RequestBody Product product){
        productService.createProduct(product);
    }

    @GetMapping(value = "/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PutMapping(value = "/{id}/update")
    public void updateProductById(@PathVariable Long id,
                               @RequestBody Product product){
        productService.updateProductById(id, product);
    }

    @DeleteMapping(value = "/{id}/delete")
    public void deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
    }

    @GetMapping(value = "/all")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    };

    @GetMapping(value = "/availible")
    public List<Product> getAllAvailibleProducts(){
        return productService.getAllAvailibleProducts();
    };
}
