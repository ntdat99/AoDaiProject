package t1708m.fashion.entity;


import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Customer {
    @Id
    private int id;
    private String username;
    private String pass;
    private String email;
    private String address;
    private String phone;
    private long updatedAt;
    private long createdAt;
    private long deletedAt;
    private int status;

    public Customer(int id, String username, String pass, String email, String address, String phone, long updatedAt, long createdAt, long deletedAt, int status) {
        this.id = id;
        this.username = username;
        this.pass = pass;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.deletedAt = deletedAt;
        this.status = status;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
