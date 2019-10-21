package t1708m.fashion.entity;

public class Admin {
    private int adminId;
    private String username;
    private String password;
    private String email;
    private String phone;
    private long uodatedAt;
    private long createdAt;
    private long deletedAt;

    public Admin() {
    }

    public Admin(int adminId, String username, String password, String email, String phone, long uodatedAt, long createdAt, long deletedAt) {
        this.adminId = adminId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.uodatedAt = uodatedAt;
        this.createdAt = createdAt;
        this.deletedAt = deletedAt;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
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
}
