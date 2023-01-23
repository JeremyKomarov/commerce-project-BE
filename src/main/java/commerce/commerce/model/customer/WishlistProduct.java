package commerce.commerce.model.customer;

public class WishlistProduct {
    private Long id;
    private Long customerId;
    private Long ProductId;

    public WishlistProduct(Long id, Long customerId, Long ProductId) {
        this.id = id;
        this.customerId = customerId;
        this.ProductId = ProductId;
    }

    public Long getId() {
        return id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Long getProductId() {
        return ProductId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setProductId(Long ProductId) {
        this.ProductId = ProductId;
    }
}

