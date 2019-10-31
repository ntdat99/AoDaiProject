package t1708m.fashion.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
@Data
@Getter
@Setter
@Entity
public class Article {
    @Id
    private int id;
    private String title;
    private String description;
    private String image;
    private int status;
    private long createdAt;
    private long updateAt;

}
