package t1708m.fashion.entity;

public class Category {
    private int categoryId;
    private int productId;
    private String name;
    private long uodatedAt;
    private long createdAt;
    private long deletedAt;

    public Category() {
    }

    public Category(int categoryId, int productId, String name, long uodatedAt, long createdAt, long deletedAt) {
        this.categoryId = categoryId;
        this.productId = productId;
        this.name = name;
        this.uodatedAt = uodatedAt;
        this.createdAt = createdAt;
        this.deletedAt = deletedAt;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
