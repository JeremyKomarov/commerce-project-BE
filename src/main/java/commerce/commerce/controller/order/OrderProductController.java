package commerce.commerce.controller.order;

import commerce.commerce.model.inventory.Product;
import commerce.commerce.model.order.OrderProduct;
import commerce.commerce.service.order.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orderProduct")
public class OrderProductController {

    @Autowired
    OrderProductService orderProductService;
    @CrossOrigin
    @PostMapping(value = "/create")
    public void createOrderProduct(@RequestBody OrderProduct orderProduct) throws Exception {
        orderProductService.createOrderProduct(orderProduct);
    }
    @CrossOrigin
    @GetMapping(value = "/{id}")
    public OrderProduct getOrderProductById(@PathVariable Long id){
        return orderProductService.getOrderProductById(id);
    }
    @CrossOrigin
    @PutMapping(value = "/{id}/update")
    public void updateOrderProductById(@PathVariable Long id,
                                @RequestBody OrderProduct orderProduct ){
        orderProductService.updateOrderProductById(id, orderProduct);
    }
    @CrossOrigin
    @DeleteMapping(value = "/{id}/delete")
    public void deleteOrderProductById(@PathVariable Long id){
        orderProductService.deleteOrderProductById(id);
    }

    @CrossOrigin
    @GetMapping(value = "/{customerId}/all")
    public List<Product> getAllOrderProductsByCustomerId(@PathVariable Long customerId){
        return orderProductService.getAllOrderProductsByCustomerId(customerId);
    }
}
