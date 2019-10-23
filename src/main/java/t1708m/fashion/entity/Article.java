package t1708m.fashion.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Article {
    @Id
    private int id;
    private int title;
    private String description;
    private String image;
    private int status;

}
