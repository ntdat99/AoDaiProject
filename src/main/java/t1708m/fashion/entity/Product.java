package t1708m.fashion.entity;

public class Product {
    private int productId;
    private String productName;
    private int categoryId;
    private int price;
    private String description;
    private String size;
    private String color;
    private long quantity;
    private long uodatedAt;
    private long createdAt;
    private long deletedAt;
    private int status;
    private String gender;
    private String delivery;
    private String image;

    public Product(int productId, String productName, int categoryId, int price, String description, String size, String color, long quantity, long uodatedAt, long createdAt, long deletedAt, int status, String gender, String delivery, String image) {
        this.productId = productId;
        this.productName = productName;
        this.categoryId = categoryId;
        this.price = price;
        this.description = description;
        this.size = size;
        this.color = color;
        this.quantity = quantity;
        this.uodatedAt = uodatedAt;
        this.createdAt = createdAt;
        this.deletedAt = deletedAt;
        this.status = status;
        this.gender = gender;
        this.delivery = delivery;
        this.image = image;
    }

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public long getUodatedAt() {
        return uodatedAt;
    }

    public void setUodatedAt(long uodatedAt) {
        this.uodatedAt = uodatedAt;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(long deletedAt) {
        this.deletedAt = deletedAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
