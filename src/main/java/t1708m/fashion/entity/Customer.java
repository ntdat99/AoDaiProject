package t1708m.fashion.entity;

public class Customer {
    private int customerId;
    private String username;
    private String password;
    private String email;
    private String address;
    private String phone;
    private long uodatedAt;
    private long createdAt;
    private long deletedAt;
    private int status;

    public Customer(int customerId, String username, String password, String email, String address, String phone, long uodatedAt, long createdAt, long deletedAt, int status) {
        this.customerId = customerId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.uodatedAt = uodatedAt;
        this.createdAt = createdAt;
        this.deletedAt = deletedAt;
        this.status = status;
    }

    public Customer() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
