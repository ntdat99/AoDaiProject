package t1708m.fashion.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Order {
    @Id
    private int customerId;
    private long oderDate;
    private long shipperDate;
    private long shipcost;
    private String phone;
    private String address;

    public Order(int customerId, long oderDate, long shipperDate, long shipcost, String phone, String address) {
        this.customerId = customerId;
        this.oderDate = oderDate;
        this.shipperDate = shipperDate;
        this.shipcost = shipcost;
        this.phone = phone;
        this.address = address;
    }

    public Order() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public long getOderDate() {
        return oderDate;
    }

    public void setOderDate(long oderDate) {
        this.oderDate = oderDate;
    }

    public long getShipperDate() {
        return shipperDate;
    }

    public void setShipperDate(long shipperDate) {
        this.shipperDate = shipperDate;
    }

    public long getShipcost() {
        return shipcost;
    }

    public void setShipcost(long shipcost) {
        this.shipcost = shipcost;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
