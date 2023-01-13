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
    @CrossOrigin
    @PostMapping(value = "/create")
    public void createProduct(@RequestBody Product product){
        productService.createProduct(product);
    }
    @CrossOrigin
    @GetMapping(value = "/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }
    @CrossOrigin
    @PutMapping(value = "/{id}/update")
    public void updateProductById(@PathVariable Long id,
                               @RequestBody Product product){
        productService.updateProductById(id, product);
    }
    @CrossOrigin
    @DeleteMapping(value = "/{id}/delete")
    public void deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
    }
    @CrossOrigin
    @GetMapping(value = "/all")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @CrossOrigin
    @GetMapping(value = "/availible")
    public List<Product> getAllAvailibleProducts(){
        return productService.getAllAvailibleProducts();
    };
}
