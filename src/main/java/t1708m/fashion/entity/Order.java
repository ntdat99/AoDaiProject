package t1708m.fashion.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Order {
    private int accountId;
    private int productId;
    private long orderDate;
    private String address;
    private String phone;
    private long createdAt;
    private long createdBy;
    private String totalPrice;

    public Order(int accountId, long orderDate, String address, String phone, long createdAt, long createdBy, String totalPrice) {
        this.accountId = accountId;
        this.orderDate = orderDate;
        this.address = address;
        this.phone = phone;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.totalPrice = totalPrice;
    }
    public Order() {
    }
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public long getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(long orderDate) {
        this.orderDate = orderDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }
}
