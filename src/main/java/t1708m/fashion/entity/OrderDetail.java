package t1708m.fashion.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderDetail {
    @Id
    private int productId;
    private int quantity;
    private String price;
    private String phone;
    private String email;
    private String address;

    public OrderDetail(int productId, int quantity, String price, String phone, String email, String address) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public OrderDetail() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int producId) {
        this.productId = producId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
