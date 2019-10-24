package t1708m.fashion.entity;


import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Design {
    @Id
    private int id;
    private int productId;
    private int categoryId;
    private String priceCategory;
    private String color;
    private String price;
    private String fabric;
    private String shoulderSize;
    private String stomachSize;
    private String armSize;
    private String image;
    private String description;
    private long updatedAt;
    private long createdAt;
    private long deletedAt;
    private int status;

    public Design(int id, int productId, int categoryId, String priceCategory, String color, String price, String fabric, String shoulderSize, String stomachSize, String armSize, String image, String description, long updatedAt, long createdAt, long deletedAt, int status) {
        this.id = id;
        this.productId = productId;
        this.categoryId = categoryId;
        this.priceCategory = priceCategory;
        this.color = color;
        this.price = price;
        this.fabric = fabric;
        this.shoulderSize = shoulderSize;
        this.stomachSize = stomachSize;
        this.armSize = armSize;
        this.image = image;
        this.description = description;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.deletedAt = deletedAt;
        this.status = status;
    }

    public Design() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getPriceCategory() {
        return priceCategory;
    }

    public void setPriceCategory(String priceCategory) {
        this.priceCategory = priceCategory;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFabric() {
        return fabric;
    }

    public void setFabric(String fabric) {
        this.fabric = fabric;
    }

    public String getShoulderSize() {
        return shoulderSize;
    }

    public void setShoulderSize(String shoulderSize) {
        this.shoulderSize = shoulderSize;
    }

    public String getStomachSize() {
        return stomachSize;
    }

    public void setStomachSize(String stomachSize) {
        this.stomachSize = stomachSize;
    }

    public String getArmSize() {
        return armSize;
    }

    public void setArmSize(String armSize) {
        this.armSize = armSize;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
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
}
