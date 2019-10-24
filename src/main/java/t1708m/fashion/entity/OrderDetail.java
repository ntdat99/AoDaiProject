package t1708m.fashion.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int orderId;
    private int productId;
    private String deliAdress;
    private String quantity;
    private String phone;
    private String totalPrice;
    private long createdAt;
    private int status;

    public OrderDetail(int orderId, int productId, String deliAdress, String quantity, String phone, String totalPrice, long createdAt, int status) {
        this.orderId = orderId;
        this.productId = productId;
        this.deliAdress = deliAdress;
        this.quantity = quantity;
        this.phone = phone;
        this.totalPrice = totalPrice;
        this.createdAt = createdAt;
        this.status = status;
    }

    public OrderDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getDeliAdress() {
        return deliAdress;
    }

    public void setDeliAdress(String deliAdress) {
        this.deliAdress = deliAdress;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
