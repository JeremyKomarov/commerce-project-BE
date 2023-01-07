package commerce.commerce.controller.order;

import commerce.commerce.model.order.Order;
import commerce.commerce.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @CrossOrigin
    @PostMapping(value = "/create")
    public void createOrder(@RequestBody Order order) throws Exception {
        orderService.createOrder(order);
    }
    @CrossOrigin
    @GetMapping(value = "/{id}")
    public Order getOrderById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }
    @CrossOrigin
    @PutMapping(value = "/{id}/update")
    public void updateOrderById(@PathVariable Long id,
                                @RequestBody Order order ){
        orderService.updateOrderById(id, order);
    }
    @CrossOrigin
    @DeleteMapping(value = "/{id}/delete")
    public void deleteOrderById(@PathVariable Long id){
        orderService.deleteOrderById(id);
    }
}
