package t1708m.fashion.entity;

public class Contact {
    private int contectId;
    private String content;
    private int status;

    public Contact(int contectId, String content, int status) {
        this.contectId = contectId;
        this.content = content;
        this.status = status;
    }

    public Contact() {
    }

    public int getContectId() {
        return contectId;
    }

    public void setContectId(int contectId) {
        this.contectId = contectId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
