package commerce.commerce.model.customer;

import commerce.commerce.model.inventory.Product;

import java.util.List;

public class CustomerProfileResponse {
    private Customer customer;
    private List<Product> wishlistProducts;
    private List<Product> cartProducts;

    public CustomerProfileResponse(Customer customer, List<Product> wishlistProducts, List<Product> cartProducts) {
        this.customer = customer;
        this.wishlistProducts = wishlistProducts;
        this.cartProducts = cartProducts;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getWishlistProducts() {
        return wishlistProducts;
    }

    public List<Product> getCartProducts() {
        return cartProducts;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setWishlistProducts(List<Product> products) {
        this.wishlistProducts = products;
    }

    public void setCartProducts(List<Product> cartProducts) {
        this.cartProducts = cartProducts;
    }
}
