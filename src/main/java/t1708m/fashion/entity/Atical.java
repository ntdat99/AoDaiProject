package t1708m.fashion.entity;

public class Atical {
    private int articalId;
    private String title;
    private String content;
    private String image;
    private long uodatedAt;
    private long createdAt;
    private long deletedAt;
    private int status;

    public Atical(int articalId, String title, String content, String image, long uodatedAt, long createdAt, long deletedAt, int status) {
        this.articalId = articalId;
        this.title = title;
        this.content = content;
        this.image = image;
        this.uodatedAt = uodatedAt;
        this.createdAt = createdAt;
        this.deletedAt = deletedAt;
        this.status = status;
    }

    public Atical() {
    }

    public int getArticalId() {
        return articalId;
    }

    public void setArticalId(int articalId) {
        this.articalId = articalId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
