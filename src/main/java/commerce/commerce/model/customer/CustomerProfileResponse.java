package commerce.commerce.model.customer;

import commerce.commerce.model.inventory.ProductResponse;
import commerce.commerce.model.order.OrderList;

import java.util.List;

public class CustomerProfileResponse {
    private Customer customer;
    private List<ProductResponse> wishlistProducts;
    private List<ProductResponse> cartProducts;
    private List<OrderList> orderLists;

    public CustomerProfileResponse(Customer customer, List<ProductResponse> wishlistProducts, List<ProductResponse> cartProducts, List<OrderList> orderLists) {
        this.customer = customer;
        this.wishlistProducts = wishlistProducts;
        this.cartProducts = cartProducts;
        this.orderLists = orderLists;

    }

    public Customer getCustomer() {
        return customer;
    }

    public List<ProductResponse> getWishlistProducts() {
        return wishlistProducts;
    }

    public List<ProductResponse> getCartProducts() {
        return cartProducts;
    }

    public List<OrderList> getOrderLists() {
        return orderLists;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setWishlistProducts(List<ProductResponse> products) {
        this.wishlistProducts = products;
    }

    public void setCartProducts(List<ProductResponse> cartProducts) {
        this.cartProducts = cartProducts;
    }

    public void setOrderLists(List<OrderList> orderLists) {
        this.orderLists = orderLists;
    }
}
