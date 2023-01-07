package commerce.commerce.model.order;

import commerce.commerce.model.customer.Customer;

import java.util.List;

public class OrderRequest {
    private Customer customer;
    private Order order;
    private List<OrderProduct> orderProducts;

    public OrderRequest(Customer customer, Order order, List<OrderProduct> orderProducts) {
        this.customer = customer;
        this.order = order;
        this.orderProducts = orderProducts;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Order getOrder() {
        return order;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }
}
