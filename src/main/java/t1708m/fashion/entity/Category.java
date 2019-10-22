package t1708m.fashion.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {
    private int id;
    private String cateName;
    private String catePrice;
    private long updatedAt;
    private long updatedBy;
    private long createdAt;
    private long createdBy;
    private long deletedAt;
    private int status;

    public Category(int id, String cateName, String catePrice, long updatedAt, long updatedBy, long createdAt, long createdBy, long deletedAt, int status) {
        this.id = id;
        this.cateName = cateName;
        this.catePrice = catePrice;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.deletedAt = deletedAt;
        this.status = status;
    }

    public Category() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getCatePrice() {
        return catePrice;
    }

    public void setCatePrice(String catePrice) {
        this.catePrice = catePrice;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(long createdBy) {
        this.createdBy = createdBy;
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
