package t1708m.fashion.entity;

public class Role {
    private int Id;
    private String name;
    private long uodatedAt;
    private long createdAt;
    private long deletedAt;
    private long uodatedBy;
    private long createdBy;
    private int status;

    public Role(int id, String name, long uodatedAt, long createdAt, long deletedAt, long uodatedBy, long createdBy, int status) {
        Id = id;
        this.name = name;
        this.uodatedAt = uodatedAt;
        this.createdAt = createdAt;
        this.deletedAt = deletedAt;
        this.uodatedBy = uodatedBy;
        this.createdBy = createdBy;
        this.status = status;
    }

    public Role() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public long getUodatedBy() {
        return uodatedBy;
    }

    public void setUodatedBy(long uodatedBy) {
        this.uodatedBy = uodatedBy;
    }

    public long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(long createdBy) {
        this.createdBy = createdBy;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
