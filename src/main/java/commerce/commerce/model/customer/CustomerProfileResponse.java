package commerce.commerce.model.customer;

import commerce.commerce.model.inventory.Product;

import java.util.List;

public class CustomerProfileResponse {
    private Customer customer;
    private List<Product> products;

    public CustomerProfileResponse(Customer customer, List<Product> products) {
        this.customer = customer;
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getFavoriteProducts() {
        return products;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setFavoriteProducts(List<Product> products) {
        this.products = products;
    }
}
