package t1708m.fashion.entity;

public class OrderDetail {
    private int producId;
    private int quantity;
    private String price;
    private String phone;
    private String email;
    private String address;

    public OrderDetail(int producId, int quantity, String price, String phone, String email, String address) {
        this.producId = producId;
        this.quantity = quantity;
        this.price = price;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public OrderDetail() {
    }

    public int getProducId() {
        return producId;
    }

    public void setProducId(int producId) {
        this.producId = producId;
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
