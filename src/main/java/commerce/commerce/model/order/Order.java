package commerce.commerce.model.order;

import java.time.LocalDate;

public class Order {
    private Long id;
    private Long customerId;
    private LocalDate orderDate;
    private String shippingAddress;
    private Long totalProducts;
    private Long totalPrice;
    private String status;

    public Order(Long id, Long customerId, LocalDate orderDate, String shippingAddress, Long totalProducts, Long totalPrice, String status) {
        this.id = id;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
        this.totalProducts = totalProducts;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public Long getTotalProducts() {
        return totalProducts;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public void setTotalProducts(Long totalProducts) {
        this.totalProducts = totalProducts;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
