package commerce.commerce.model.order;

public class OrderProductCount {
    private Long count;

    public OrderProductCount(Long count) {
        this.count = count;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
