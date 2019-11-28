package t1708m.fashion.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;

@Data
@Getter
@Setter
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Lob
    private String title;
    @Lob
    private String description;
    @Lob
    private String content;
    private String thumbnail;

    private long updateAt;
    private long deletedAt;
    private int status;

    @ManyToOne
    @JoinColumn(name = "created_by_id")
    private Account createdBy; // tạo bởi ai.

    @ManyToOne
    @JoinColumn(name = "updated_by_id")
    private Account updatedBy; // update bởi ai.

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ArticleCategory category;

    public enum Status {

        ACTIVE(1), DEACTIVE(0), DELETED(-1);

        private int value;

        Status(int i) {
            this.value = i;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
    public ArrayList<String> getPhotoLinks() {
        ArrayList<String> photoLinks = new ArrayList<>();
        if (this.thumbnail != null && this.thumbnail.length() > 0) {
            String[] photoArrays = this.thumbnail.split(",");
            for (int i = 0; i < photoArrays.length; i++) {
                photoLinks.add(photoArrays[i]);
            }
        } else {
            photoLinks.add("");
        }
        return photoLinks;
    }
}
