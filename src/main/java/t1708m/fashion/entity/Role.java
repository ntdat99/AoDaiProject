package t1708m.fashion.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {
    @javax.persistence.Id
    private int Id;
    private String name;

    private long createdAt;
    private long deletedAt;
    private long updatedBy;
    private long createdBy;
    private int status;

    public Role() {
    }

    public Role(int id, String name, long createdAt, long deletedAt, long updatedBy, long createdBy, int status) {
        Id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.deletedAt = deletedAt;
        this.updatedBy = updatedBy;
        this.createdBy = createdBy;
        this.status = status;
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

    public long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(long updatedBy) {
        this.updatedBy = updatedBy;
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
