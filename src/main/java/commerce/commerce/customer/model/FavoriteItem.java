package commerce.commerce.customer.model;

public class FavoriteItem {
    private Long id;
    private Long customerId;
    private Long itemId;

    public FavoriteItem(Long id, Long customerId, Long itemId) {
        this.id = id;
        this.customerId = customerId;
        this.itemId = itemId;
    }

    public Long getId() {
        return id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
}

