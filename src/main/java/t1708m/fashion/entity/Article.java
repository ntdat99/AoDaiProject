package t1708m.fashion.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    @Lob
    private String content;
    private String thumbnail;

    private long updateAt;
    private long deletedAt;
    private int status;

    @OneToOne(optional = true)
    @JoinColumn(name = "created_by_id", referencedColumnName = "id", nullable = true)
    private Account createdBy; // tạo bởi ai.

    @OneToOne(optional = true)
    @JoinColumn(name = "updated_by_id", referencedColumnName = "id", nullable = true)
    private Account updatedBy; // update bởi ai.

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
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
}
