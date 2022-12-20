package commerce.commerce.inventory.model;

public class Item {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String img;
    private Long quantity;

    public Item(Long id, String name, String description, Double price, String img, Long quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.img = img;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getImg() {
        return img;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
