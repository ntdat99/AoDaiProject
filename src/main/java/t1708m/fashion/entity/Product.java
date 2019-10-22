package t1708m.fashion.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    private int id;
    private int categoryId;
    private String proName;
    private String proCode;
    private String proColor;
    private String proSize;
    private String proCateFab;
    private String proPrice;
    private String proPriceFab;
    private String proDescription;
    private String proQuantity;
    private String proImage;
    private String proGender;
    private String proShoulderSize;
    private String proStomachSize;
    private String proArmSize;
    private long updatedAt;
    private long updatedBy;
    private long createdAt;
    private long createdBy;
    private long deletedAt;
    private int status;

    public Product(int id, int categoryId, String proName, String proCode, String proColor, String proSize, String proCateFab, String proPrice, String proPriceFab, String proDescription, String proQuantity, String proImage, String proGender, String proShoulderSize, String proStomachSize, String proArmSize, String pro, long updatedAt, long updatedBy, long createdAt, long createdBy, long deletedAt, int status) {
        this.id = id;
        this.categoryId = categoryId;
        this.proName = proName;
        this.proCode = proCode;
        this.proColor = proColor;
        this.proSize = proSize;
        this.proCateFab = proCateFab;
        this.proPrice = proPrice;
        this.proPriceFab = proPriceFab;
        this.proDescription = proDescription;
        this.proQuantity = proQuantity;
        this.proImage = proImage;
        this.proGender = proGender;
        this.proShoulderSize = proShoulderSize;
        this.proStomachSize = proStomachSize;
        this.proArmSize = proArmSize;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.deletedAt = deletedAt;
        this.status = status;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProCode() {
        return proCode;
    }

    public void setProCode(String proCode) {
        this.proCode = proCode;
    }

    public String getProColor() {
        return proColor;
    }

    public void setProColor(String proColor) {
        this.proColor = proColor;
    }

    public String getProSize() {
        return proSize;
    }

    public void setProSize(String proSize) {
        this.proSize = proSize;
    }

    public String getProCateFab() {
        return proCateFab;
    }

    public void setProCateFab(String proCateFab) {
        this.proCateFab = proCateFab;
    }

    public String getProPrice() {
        return proPrice;
    }

    public void setProPrice(String proPrice) {
        this.proPrice = proPrice;
    }

    public String getProPriceFab() {
        return proPriceFab;
    }

    public void setProPriceFab(String proPriceFab) {
        this.proPriceFab = proPriceFab;
    }

    public String getProDescription() {
        return proDescription;
    }

    public void setProDescription(String proDescription) {
        this.proDescription = proDescription;
    }

    public String getProQuantity() {
        return proQuantity;
    }

    public void setProQuantity(String proQuantity) {
        this.proQuantity = proQuantity;
    }

    public String getProImage() {
        return proImage;
    }

    public void setProImage(String proImage) {
        this.proImage = proImage;
    }

    public String getProGender() {
        return proGender;
    }

    public void setProGender(String proGender) {
        this.proGender = proGender;
    }

    public String getProShoulderSize() {
        return proShoulderSize;
    }

    public void setProShoulderSize(String proShoulderSize) {
        this.proShoulderSize = proShoulderSize;
    }

    public String getProStomachSize() {
        return proStomachSize;
    }

    public void setProStomachSize(String proStomachSize) {
        this.proStomachSize = proStomachSize;
    }

    public String getProArmSize() {
        return proArmSize;
    }

    public void setProArmSize(String proArmSize) {
        this.proArmSize = proArmSize;
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
