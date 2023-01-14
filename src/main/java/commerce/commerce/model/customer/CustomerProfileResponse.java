package commerce.commerce.model.customer;

import commerce.commerce.model.inventory.Product;

import java.util.List;

public class CustomerProfileResponse {
    private Customer customer;
    private List<Product> favoriteProducts;
    private List<Product> cartProducts;

    public CustomerProfileResponse(Customer customer, List<Product> favoriteProducts, List<Product> cartProducts) {
        this.customer = customer;
        this.favoriteProducts = favoriteProducts;
        this.cartProducts = cartProducts;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getFavoriteProducts() {
        return favoriteProducts;
    }

    public List<Product> getCartProducts() {
        return cartProducts;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setFavoriteProducts(List<Product> products) {
        this.favoriteProducts = products;
    }

    public void setCartProducts(List<Product> cartProducts) {
        this.cartProducts = cartProducts;
    }
}
