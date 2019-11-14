package t1708m.fashion.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Data
@Getter
@Setter
@Entity
public class ArticleCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String image;
    private String description;

    private long updatedAt;
    private long createdAt;
    private long deletedAt;
    private int status;

    @OneToOne(optional = true)
    @JoinColumn(name = "created_by_id", referencedColumnName = "id", nullable = true)
    private Account createdBy; // tạo bởi ai.

    @OneToOne(optional = true)
    @JoinColumn(name = "updated_by_id", referencedColumnName = "id", nullable = true)
    private Account updatedBy; // update bởi ai.

    @OneToMany(mappedBy = "category", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    private Set<Article> articles;

    public ArticleCategory() {
    }
}
